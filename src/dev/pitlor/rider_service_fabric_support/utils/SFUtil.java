package dev.pitlor.rider_service_fabric_support.utils;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.ProjectScope;
import dev.pitlor.rider_service_fabric_support.file_types.ServiceFabricFileType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SFUtil {
	public static List<VirtualFile> getSFFolders(Project project) {
		GlobalSearchScope scope = ProjectScope
			.getContentScope(project)
			.intersectWith(GlobalSearchScope.notScope(ProjectScope.getLibrariesScope(project)));
		return FileTypeIndex.getFiles(new ServiceFabricFileType(), scope)
			.stream()
			.filter((file) -> file != null && file.isValid())
			.map(VirtualFile::getParent)
			.collect(Collectors.toList());
	}

	public static List<String> getPublishProfiles(VirtualFile sfFolder) {
		return new ArrayList<>();
	}
}