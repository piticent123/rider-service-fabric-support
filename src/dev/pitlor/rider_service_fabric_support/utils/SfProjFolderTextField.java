package dev.pitlor.rider_service_fabric_support.utils;

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.TextFieldWithHistory;
import com.intellij.ui.TextFieldWithHistoryWithBrowseButton;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.ui.SwingHelper;
import com.intellij.webcore.ui.PathShortener;
import dev.pitlor.rider_service_fabric_support.Bundle;

import java.util.Collections;
import java.util.List;

public class SfProjFolderTextField extends TextFieldWithHistoryWithBrowseButton {
	public SfProjFolderTextField(Project project) {
		super();

		TextFieldWithHistory textFieldWithHistory = getChildComponent();
		textFieldWithHistory.setHistorySize(-1);
		textFieldWithHistory.setMinimumAndPreferredWidth(0);
		textFieldWithHistory.setHistory(Collections.singletonList(""));
		PathShortener.enablePathShortening(textFieldWithHistory.getTextEditor(), null);

		SwingHelper.addHistoryOnExpansion(textFieldWithHistory, () -> {
			textFieldWithHistory.setHistory(Collections.emptyList());
			List<VirtualFile> sfFolders = SFUtil.getSFFolders(project);
			List<String> newFilePaths = ContainerUtil.map(sfFolders, folder -> {
				String path = FileUtil.toSystemDependentName(folder.getPath());
				return FileUtil.getLocationRelativeToUserHome(path, false);
			});
			Collections.sort(newFilePaths);
			return newFilePaths;
		});

		SwingHelper.installFileCompletionAndBrowseDialog(
			project,
			this,
			Bundle.string("run_config.sf_project_folder.dialog_title"),
			FileChooserDescriptorFactory.createSingleFolderDescriptor()
		);
	}
}
