/*
 * Copyright (c) 2021-present, NoBugLady Contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See
 * the License for the specific language governing permissions and limitations under the License.
 */
package io.github.nobuglady.network.ui.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import io.github.nobuglady.network.fw.component.IFlowAccessor;
import io.github.nobuglady.network.fw.constant.FlowStatus;
import io.github.nobuglady.network.fw.persistance.entity.FlowEntity;
import io.github.nobuglady.network.fw.persistance.entity.HistoryEdgeEntity;
import io.github.nobuglady.network.fw.persistance.entity.HistoryFlowEntity;
import io.github.nobuglady.network.fw.persistance.entity.HistoryNodeEntity;
import io.github.nobuglady.network.ui.SpringContextBridge;

/**
 * 
 * @author NoBugLady
 *
 */
public class FlowAccessor implements IFlowAccessor {

	/** key: flowId, historyId */
	public static Map<String, FlowEntity> flowMap = new HashMap<>();

	private HistoryFlowDao historyFlowDao;
	private HistoryNodeDao historyNodeDao;
	private HistoryEdgeDao historyEdgeDao;

	public FlowAccessor() {
		historyFlowDao = SpringContextBridge.getInstance().getHistoryFlowDao();
		historyNodeDao = SpringContextBridge.getInstance().getHistoryNodeDao();
		historyEdgeDao = SpringContextBridge.getInstance().getHistoryEdgeDao();
	}

	/**
	 * createHistoryId
	 * 
	 * @return HistoryId
	 */
	public String createHistoryId() {
		return UUID.randomUUID().toString();

	}

	/**
	 * selectFlowByKey
	 * 
	 * @param flowId    flowId
	 * @param historyId historyId
	 * @return HistoryFlowEntity
	 */
	public HistoryFlowEntity selectFlowByKey(String flowId, String historyId) {
		return historyFlowDao.selectByKey(flowId, historyId);
	}

	/**
	 * selectNodeByFlowHistoryId
	 * 
	 * @param flowId    flowId
	 * @param historyId historyId
	 * @return HistoryNodeEntity
	 */
	public List<HistoryNodeEntity> selectNodeByFlowHistoryId(String flowId, String historyId) {
		return historyNodeDao.selectByFlowHistoryId(flowId, historyId);
	}

	/**
	 * selectNodeByKey
	 * 
	 * @param flowId    flowId
	 * @param nodeId    nodeId
	 * @param historyId historyId
	 * @return HistoryNodeEntity
	 */
	public HistoryNodeEntity selectNodeByKey(String flowId, String nodeId, String historyId) {
		return historyNodeDao.selectByKey(flowId, nodeId, historyId);
	}

	/**
	 * updateNodeStatusByNodeId
	 * 
	 * @param flowId     flowId
	 * @param historyId  historyId
	 * @param nodeId     nodeId
	 * @param nodeStatus nodeStatus
	 */
	public void updateNodeStatusByNodeId(String flowId, String historyId, String nodeId, int nodeStatus) {
		historyNodeDao.updateStatusByNodeId(flowId, historyId, nodeId, nodeStatus);
	}

	/**
	 * selectNodeListByStatus
	 * 
	 * @param flowId     flowId
	 * @param historyId  historyId
	 * @param nodeStatus nodeStatus
	 * @return HistoryNodeEntity
	 */
	public List<HistoryNodeEntity> selectNodeListByStatus(String flowId, String historyId, int nodeStatus) {
		return historyNodeDao.selectNodeListByStatus(flowId, historyId, nodeStatus);
	}

	/**
	 * selectNodeListByStatusDetail
	 * 
	 * @param flowId           flowId
	 * @param historyId        historyId
	 * @param nodeStatus       nodeStatus
	 * @param nodeStatusDetail nodeStatusDetail
	 * @return HistoryNodeEntity
	 */
	public List<HistoryNodeEntity> selectNodeListByStatusDetail(String flowId, String historyId, int nodeStatus,
			int nodeStatusDetail) {
		return historyNodeDao.selectNodeListByStatusDetail(flowId, historyId, nodeStatus, nodeStatusDetail);
	}

	/**
	 * selectEdgeByFlowHistoryId
	 * 
	 * @param flowId    flowId
	 * @param historyId historyId
	 * @return HistoryEdgeEntity
	 */
	public List<HistoryEdgeEntity> selectEdgeByFlowHistoryId(String flowId, String historyId) {
		return historyEdgeDao.selectByFlowHistoryId(flowId, historyId);
	}

	/**
	 * updateFlowStatus
	 * 
	 * @param flowId     flowId
	 * @param historyId  historyId
	 * @param flowStatus flowStatus
	 */
	public void updateFlowStatus(String flowId, String historyId, int flowStatus) {
		historyFlowDao.updateFlowStatus(flowId, historyId, flowStatus);
	}

	/**
	 * updateNodeStatusDetailByNodeId
	 * 
	 * @param flowId           flowId
	 * @param historyId        historyId
	 * @param nodeId           nodeId
	 * @param nodeStatus       nodeStatus
	 * @param nodeStatusDetail nodeStatusDetail
	 */
	public void updateNodeStatusDetailByNodeId(String flowId, String historyId, String nodeId, int nodeStatus,
			int nodeStatusDetail) {
		historyNodeDao.updateStatusDetailByNodeId(flowId, historyId, nodeId, nodeStatus, nodeStatusDetail);
	}

	/**
	 * updateNodeReturnValueByNodeId
	 * 
	 * @param flowId      flowId
	 * @param historyId   historyId
	 * @param nodeId      nodeId
	 * @param returnValue returnValue
	 */
	public void updateNodeReturnValueByNodeId(String flowId, String historyId, String nodeId, String returnValue) {
		historyNodeDao.updateReturnValueByNodeId(flowId, historyId, nodeId, returnValue);
	}

	/**
	 * updateEdgeStatusByKey
	 * 
	 * @param flowId     flowId
	 * @param historyId  historyId
	 * @param edgeId     edgeId
	 * @param edgeStatus edgeStatus
	 */
	public void updateEdgeStatusByKey(String flowId, String historyId, String edgeId, int edgeStatus) {
		historyEdgeDao.updateStatusByKey(flowId, historyId, edgeId, edgeStatus);
	}

	/**
	 * saveFlow
	 * 
	 * @param flowEntity flowEntity
	 */
	public void saveFlow(FlowEntity flowEntity) {

		historyFlowDao.save(flowEntity.flowEntity);

		for (HistoryEdgeEntity historyEdgeEntity : flowEntity.edgeEntityList) {
			historyEdgeDao.save(historyEdgeEntity);
		}

		for (HistoryNodeEntity historyNodeEntity : flowEntity.nodeEntityList) {
			historyNodeDao.save(historyNodeEntity);
		}

	}

	/**
	 * removeFlow
	 * 
	 * @param flowId    flowId
	 * @param historyId historyId
	 */
	public void removeFlow(String flowId, String historyId) {

		historyFlowDao.deleteAllByKey(flowId, historyId);
		historyNodeDao.deleteByFlowHistoryId(flowId, historyId);
		historyEdgeDao.deleteByFlowHistoryId(flowId, historyId);
	}

	/**
	 * removeAllComplete
	 * 
	 */
	public void removeAllComplete() {

		historyNodeDao.deleteByFlowStatus(FlowStatus.COMPLETE);
		historyEdgeDao.deleteByFlowStatus(FlowStatus.COMPLETE);
		historyFlowDao.deleteAllByStatus(FlowStatus.COMPLETE);
	}

	/**
	 * removeAllError
	 */
	public void removeAllError() {

		historyNodeDao.deleteByFlowStatus(FlowStatus.ERROR);
		historyEdgeDao.deleteByFlowStatus(FlowStatus.ERROR);
		historyFlowDao.deleteAllByStatus(FlowStatus.ERROR);
	}

	/**
	 * selectAll
	 * 
	 * @return HistoryFlowEntity
	 */
	public List<HistoryFlowEntity> selectAll() {
		return historyFlowDao.selectAll();
	}

}
