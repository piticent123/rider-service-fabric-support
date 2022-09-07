package com.microsoft.fabric.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Defines a health policy used to evaluate the health of the cluster or of a cluster node. */
@Fluent
public final class ClusterHealthPolicy {
    /*
     * Indicates whether warnings are treated with the same severity as errors.
     */
    @JsonProperty(value = "ConsiderWarningAsError")
    private Boolean considerWarningAsError;

    /*
     * The maximum allowed percentage of unhealthy nodes before reporting an
     * error. For example, to allow 10% of nodes to be unhealthy, this value
     * would be 10.
     *
     * The percentage represents the maximum tolerated percentage of nodes that
     * can be unhealthy before the cluster is considered in error.
     * If the percentage is respected but there is at least one unhealthy node,
     * the health is evaluated as Warning.
     * The percentage is calculated by dividing the number of unhealthy nodes
     * over the total number of nodes in the cluster.
     * The computation rounds up to tolerate one failure on small numbers of
     * nodes. Default percentage is zero.
     *
     * In large clusters, some nodes will always be down or out for repairs, so
     * this percentage should be configured to tolerate that.
     */
    @JsonProperty(value = "MaxPercentUnhealthyNodes")
    private Integer maxPercentUnhealthyNodes;

    /*
     * The maximum allowed percentage of unhealthy applications before
     * reporting an error. For example, to allow 10% of applications to be
     * unhealthy, this value would be 10.
     *
     * The percentage represents the maximum tolerated percentage of
     * applications that can be unhealthy before the cluster is considered in
     * error.
     * If the percentage is respected but there is at least one unhealthy
     * application, the health is evaluated as Warning.
     * This is calculated by dividing the number of unhealthy applications over
     * the total number of application instances in the cluster, excluding
     * applications of application types that are included in the
     * ApplicationTypeHealthPolicyMap.
     * The computation rounds up to tolerate one failure on small numbers of
     * applications. Default percentage is zero.
     */
    @JsonProperty(value = "MaxPercentUnhealthyApplications")
    private Integer maxPercentUnhealthyApplications;

    /*
     * Defines a map with max percentage unhealthy applications for specific
     * application types.
     * Each entry specifies as key the application type name and as value an
     * integer that represents the MaxPercentUnhealthyApplications percentage
     * used to evaluate the applications of the specified application type.
     *
     * The application type health policy map can be used during cluster health
     * evaluation to describe special application types.
     * The application types included in the map are evaluated against the
     * percentage specified in the map, and not with the global
     * MaxPercentUnhealthyApplications defined in the cluster health policy.
     * The applications of application types specified in the map are not
     * counted against the global pool of applications.
     * For example, if some applications of a type are critical, the cluster
     * administrator can add an entry to the map for that application type
     * and assign it a value of 0% (that is, do not tolerate any failures).
     * All other applications can be evaluated with
     * MaxPercentUnhealthyApplications set to 20% to tolerate some failures out
     * of the thousands of application instances.
     * The application type health policy map is used only if the cluster
     * manifest enables application type health evaluation using the
     * configuration entry for
     * HealthManager/EnableApplicationTypeHealthEvaluation.
     */
    @JsonProperty(value = "ApplicationTypeHealthPolicyMap")
    private List<ApplicationTypeHealthPolicyMapItem> applicationTypeHealthPolicyMap;

    /*
     * Defines a map with max percentage unhealthy nodes for specific node
     * types.
     * Each entry specifies as key the node type name and as value an integer
     * that represents the MaxPercentUnhealthyNodes percentage used to evaluate
     * the nodes of the specified node type.
     *
     * The node type health policy map can be used during cluster health
     * evaluation to describe special node types.
     * They are evaluated against the percentages associated with their node
     * type name in the map.
     * Setting this has no impact on the global pool of nodes used for
     * MaxPercentUnhealthyNodes.
     * The node type health policy map is used only if the cluster manifest
     * enables node type health evaluation using the configuration entry for
     * HealthManager/EnableNodeTypeHealthEvaluation.
     *
     * For example, given a cluster with many nodes of different types, with
     * important work hosted on node type "SpecialNodeType" that should not
     * tolerate any nodes down.
     * You can specify global MaxPercentUnhealthyNodes to 20% to tolerate some
     * failures for all nodes, but for the node type "SpecialNodeType", set the
     * MaxPercentUnhealthyNodes to 0 by
     * setting the value in the key value pair in NodeTypeHealthPolicyMapItem.
     * The key is the node type name.
     * This way, as long as no nodes of type "SpecialNodeType" are in Error
     * state,
     * even if some of the many nodes in the global pool are in Error state,
     * but below the global unhealthy percentage, the cluster would be
     * evaluated to Warning.
     * A Warning health state does not impact cluster upgrade or other
     * monitoring triggered by Error health state.
     * But even one node of type SpecialNodeType in Error would make cluster
     * unhealthy (in Error rather than Warning/Ok), which triggers rollback or
     * pauses the cluster upgrade, depending on the upgrade configuration.
     *
     * Conversely, setting the global MaxPercentUnhealthyNodes to 0, and
     * setting SpecialNodeType's max percent unhealthy nodes to 100,
     * with one node of type SpecialNodeType in Error state would still put the
     * cluster in an Error state, since the global restriction is more strict
     * in this case.
     */
    @JsonProperty(value = "NodeTypeHealthPolicyMap")
    private List<NodeTypeHealthPolicyMapItem> nodeTypeHealthPolicyMap;

    /**
     * Get the considerWarningAsError property: Indicates whether warnings are treated with the same severity as errors.
     *
     * @return the considerWarningAsError value.
     */
    public Boolean isConsiderWarningAsError() {
        return this.considerWarningAsError;
    }

    /**
     * Set the considerWarningAsError property: Indicates whether warnings are treated with the same severity as errors.
     *
     * @param considerWarningAsError the considerWarningAsError value to set.
     * @return the ClusterHealthPolicy object itself.
     */
    public ClusterHealthPolicy setConsiderWarningAsError(Boolean considerWarningAsError) {
        this.considerWarningAsError = considerWarningAsError;
        return this;
    }

    /**
     * Get the maxPercentUnhealthyNodes property: The maximum allowed percentage of unhealthy nodes before reporting an
     * error. For example, to allow 10% of nodes to be unhealthy, this value would be 10.
     *
     * <p>The percentage represents the maximum tolerated percentage of nodes that can be unhealthy before the cluster
     * is considered in error. If the percentage is respected but there is at least one unhealthy node, the health is
     * evaluated as Warning. The percentage is calculated by dividing the number of unhealthy nodes over the total
     * number of nodes in the cluster. The computation rounds up to tolerate one failure on small numbers of nodes.
     * Default percentage is zero.
     *
     * <p>In large clusters, some nodes will always be down or out for repairs, so this percentage should be configured
     * to tolerate that.
     *
     * @return the maxPercentUnhealthyNodes value.
     */
    public Integer getMaxPercentUnhealthyNodes() {
        return this.maxPercentUnhealthyNodes;
    }

    /**
     * Set the maxPercentUnhealthyNodes property: The maximum allowed percentage of unhealthy nodes before reporting an
     * error. For example, to allow 10% of nodes to be unhealthy, this value would be 10.
     *
     * <p>The percentage represents the maximum tolerated percentage of nodes that can be unhealthy before the cluster
     * is considered in error. If the percentage is respected but there is at least one unhealthy node, the health is
     * evaluated as Warning. The percentage is calculated by dividing the number of unhealthy nodes over the total
     * number of nodes in the cluster. The computation rounds up to tolerate one failure on small numbers of nodes.
     * Default percentage is zero.
     *
     * <p>In large clusters, some nodes will always be down or out for repairs, so this percentage should be configured
     * to tolerate that.
     *
     * @param maxPercentUnhealthyNodes the maxPercentUnhealthyNodes value to set.
     * @return the ClusterHealthPolicy object itself.
     */
    public ClusterHealthPolicy setMaxPercentUnhealthyNodes(Integer maxPercentUnhealthyNodes) {
        this.maxPercentUnhealthyNodes = maxPercentUnhealthyNodes;
        return this;
    }

    /**
     * Get the maxPercentUnhealthyApplications property: The maximum allowed percentage of unhealthy applications before
     * reporting an error. For example, to allow 10% of applications to be unhealthy, this value would be 10.
     *
     * <p>The percentage represents the maximum tolerated percentage of applications that can be unhealthy before the
     * cluster is considered in error. If the percentage is respected but there is at least one unhealthy application,
     * the health is evaluated as Warning. This is calculated by dividing the number of unhealthy applications over the
     * total number of application instances in the cluster, excluding applications of application types that are
     * included in the ApplicationTypeHealthPolicyMap. The computation rounds up to tolerate one failure on small
     * numbers of applications. Default percentage is zero.
     *
     * @return the maxPercentUnhealthyApplications value.
     */
    public Integer getMaxPercentUnhealthyApplications() {
        return this.maxPercentUnhealthyApplications;
    }

    /**
     * Set the maxPercentUnhealthyApplications property: The maximum allowed percentage of unhealthy applications before
     * reporting an error. For example, to allow 10% of applications to be unhealthy, this value would be 10.
     *
     * <p>The percentage represents the maximum tolerated percentage of applications that can be unhealthy before the
     * cluster is considered in error. If the percentage is respected but there is at least one unhealthy application,
     * the health is evaluated as Warning. This is calculated by dividing the number of unhealthy applications over the
     * total number of application instances in the cluster, excluding applications of application types that are
     * included in the ApplicationTypeHealthPolicyMap. The computation rounds up to tolerate one failure on small
     * numbers of applications. Default percentage is zero.
     *
     * @param maxPercentUnhealthyApplications the maxPercentUnhealthyApplications value to set.
     * @return the ClusterHealthPolicy object itself.
     */
    public ClusterHealthPolicy setMaxPercentUnhealthyApplications(Integer maxPercentUnhealthyApplications) {
        this.maxPercentUnhealthyApplications = maxPercentUnhealthyApplications;
        return this;
    }

    /**
     * Get the applicationTypeHealthPolicyMap property: Defines a map with max percentage unhealthy applications for
     * specific application types. Each entry specifies as key the application type name and as value an integer that
     * represents the MaxPercentUnhealthyApplications percentage used to evaluate the applications of the specified
     * application type.
     *
     * <p>The application type health policy map can be used during cluster health evaluation to describe special
     * application types. The application types included in the map are evaluated against the percentage specified in
     * the map, and not with the global MaxPercentUnhealthyApplications defined in the cluster health policy. The
     * applications of application types specified in the map are not counted against the global pool of applications.
     * For example, if some applications of a type are critical, the cluster administrator can add an entry to the map
     * for that application type and assign it a value of 0% (that is, do not tolerate any failures). All other
     * applications can be evaluated with MaxPercentUnhealthyApplications set to 20% to tolerate some failures out of
     * the thousands of application instances. The application type health policy map is used only if the cluster
     * manifest enables application type health evaluation using the configuration entry for
     * HealthManager/EnableApplicationTypeHealthEvaluation.
     *
     * @return the applicationTypeHealthPolicyMap value.
     */
    public List<ApplicationTypeHealthPolicyMapItem> getApplicationTypeHealthPolicyMap() {
        return this.applicationTypeHealthPolicyMap;
    }

    /**
     * Set the applicationTypeHealthPolicyMap property: Defines a map with max percentage unhealthy applications for
     * specific application types. Each entry specifies as key the application type name and as value an integer that
     * represents the MaxPercentUnhealthyApplications percentage used to evaluate the applications of the specified
     * application type.
     *
     * <p>The application type health policy map can be used during cluster health evaluation to describe special
     * application types. The application types included in the map are evaluated against the percentage specified in
     * the map, and not with the global MaxPercentUnhealthyApplications defined in the cluster health policy. The
     * applications of application types specified in the map are not counted against the global pool of applications.
     * For example, if some applications of a type are critical, the cluster administrator can add an entry to the map
     * for that application type and assign it a value of 0% (that is, do not tolerate any failures). All other
     * applications can be evaluated with MaxPercentUnhealthyApplications set to 20% to tolerate some failures out of
     * the thousands of application instances. The application type health policy map is used only if the cluster
     * manifest enables application type health evaluation using the configuration entry for
     * HealthManager/EnableApplicationTypeHealthEvaluation.
     *
     * @param applicationTypeHealthPolicyMap the applicationTypeHealthPolicyMap value to set.
     * @return the ClusterHealthPolicy object itself.
     */
    public ClusterHealthPolicy setApplicationTypeHealthPolicyMap(
            List<ApplicationTypeHealthPolicyMapItem> applicationTypeHealthPolicyMap) {
        this.applicationTypeHealthPolicyMap = applicationTypeHealthPolicyMap;
        return this;
    }

    /**
     * Get the nodeTypeHealthPolicyMap property: Defines a map with max percentage unhealthy nodes for specific node
     * types. Each entry specifies as key the node type name and as value an integer that represents the
     * MaxPercentUnhealthyNodes percentage used to evaluate the nodes of the specified node type.
     *
     * <p>The node type health policy map can be used during cluster health evaluation to describe special node types.
     * They are evaluated against the percentages associated with their node type name in the map. Setting this has no
     * impact on the global pool of nodes used for MaxPercentUnhealthyNodes. The node type health policy map is used
     * only if the cluster manifest enables node type health evaluation using the configuration entry for
     * HealthManager/EnableNodeTypeHealthEvaluation.
     *
     * <p>For example, given a cluster with many nodes of different types, with important work hosted on node type
     * "SpecialNodeType" that should not tolerate any nodes down. You can specify global MaxPercentUnhealthyNodes to 20%
     * to tolerate some failures for all nodes, but for the node type "SpecialNodeType", set the
     * MaxPercentUnhealthyNodes to 0 by setting the value in the key value pair in NodeTypeHealthPolicyMapItem. The key
     * is the node type name. This way, as long as no nodes of type "SpecialNodeType" are in Error state, even if some
     * of the many nodes in the global pool are in Error state, but below the global unhealthy percentage, the cluster
     * would be evaluated to Warning. A Warning health state does not impact cluster upgrade or other monitoring
     * triggered by Error health state. But even one node of type SpecialNodeType in Error would make cluster unhealthy
     * (in Error rather than Warning/Ok), which triggers rollback or pauses the cluster upgrade, depending on the
     * upgrade configuration.
     *
     * <p>Conversely, setting the global MaxPercentUnhealthyNodes to 0, and setting SpecialNodeType's max percent
     * unhealthy nodes to 100, with one node of type SpecialNodeType in Error state would still put the cluster in an
     * Error state, since the global restriction is more strict in this case.
     *
     * @return the nodeTypeHealthPolicyMap value.
     */
    public List<NodeTypeHealthPolicyMapItem> getNodeTypeHealthPolicyMap() {
        return this.nodeTypeHealthPolicyMap;
    }

    /**
     * Set the nodeTypeHealthPolicyMap property: Defines a map with max percentage unhealthy nodes for specific node
     * types. Each entry specifies as key the node type name and as value an integer that represents the
     * MaxPercentUnhealthyNodes percentage used to evaluate the nodes of the specified node type.
     *
     * <p>The node type health policy map can be used during cluster health evaluation to describe special node types.
     * They are evaluated against the percentages associated with their node type name in the map. Setting this has no
     * impact on the global pool of nodes used for MaxPercentUnhealthyNodes. The node type health policy map is used
     * only if the cluster manifest enables node type health evaluation using the configuration entry for
     * HealthManager/EnableNodeTypeHealthEvaluation.
     *
     * <p>For example, given a cluster with many nodes of different types, with important work hosted on node type
     * "SpecialNodeType" that should not tolerate any nodes down. You can specify global MaxPercentUnhealthyNodes to 20%
     * to tolerate some failures for all nodes, but for the node type "SpecialNodeType", set the
     * MaxPercentUnhealthyNodes to 0 by setting the value in the key value pair in NodeTypeHealthPolicyMapItem. The key
     * is the node type name. This way, as long as no nodes of type "SpecialNodeType" are in Error state, even if some
     * of the many nodes in the global pool are in Error state, but below the global unhealthy percentage, the cluster
     * would be evaluated to Warning. A Warning health state does not impact cluster upgrade or other monitoring
     * triggered by Error health state. But even one node of type SpecialNodeType in Error would make cluster unhealthy
     * (in Error rather than Warning/Ok), which triggers rollback or pauses the cluster upgrade, depending on the
     * upgrade configuration.
     *
     * <p>Conversely, setting the global MaxPercentUnhealthyNodes to 0, and setting SpecialNodeType's max percent
     * unhealthy nodes to 100, with one node of type SpecialNodeType in Error state would still put the cluster in an
     * Error state, since the global restriction is more strict in this case.
     *
     * @param nodeTypeHealthPolicyMap the nodeTypeHealthPolicyMap value to set.
     * @return the ClusterHealthPolicy object itself.
     */
    public ClusterHealthPolicy setNodeTypeHealthPolicyMap(List<NodeTypeHealthPolicyMapItem> nodeTypeHealthPolicyMap) {
        this.nodeTypeHealthPolicyMap = nodeTypeHealthPolicyMap;
        return this;
    }
}
