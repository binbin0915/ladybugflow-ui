package io.github.nobuglady.network.ui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.nobuglady.network.fw.component.FlowComponentFactory;
import io.github.nobuglady.network.fw.constant.NodeStatusDetail;
import io.github.nobuglady.network.ui.flow.Demo2Flow;

@Service
public class Demo2Service {

	@Autowired
	private Demo2Flow demo2Flow;

	/**
	 * ��������
	 */
	public String start(String username) {
		return demo2Flow.startFlow(false, username);
	}

	/**
	 * ��������ID���ڵ�ID������ʵ��ID���½ڵ�״̬(�������ѯ�û���Ϣ�����������)
	 */
	public void searchUser(String historyId) {
		FlowComponentFactory.getCompleteQueueSender().putCompleteNode(
				"FLOW_2", 
				historyId, 
				"a1a38c2e-0e05-4c68-bd49-f12aea070876", // �ڵ�ID����ѯ�û���Ϣ��
				NodeStatusDetail.COMPLETE_SUCCESS, 
				"0");
	}
	
	/**
	 * ��������ID���ڵ�ID������ʵ��ID���½ڵ�״̬(�������ѯ�Ƶ���Ϣ�����������)
	 */
	public void searchHotel(String historyId) {
		FlowComponentFactory.getCompleteQueueSender().putCompleteNode(
				"FLOW_2", 
				historyId, 
				"1a90a997-4390-470a-ae7c-626a725438d2",// �ڵ�ID����ѯ�Ƶ���Ϣ��
				NodeStatusDetail.COMPLETE_SUCCESS, 
				"0");
	}
	
	/**
	 * ��������ID���ڵ�ID������ʵ��ID���½ڵ�״̬(������µ������������)
	 */
	public void order(String historyId) {
		FlowComponentFactory.getCompleteQueueSender().putCompleteNode(
				"FLOW_2", 
				historyId, 
				"52289e99-363d-4453-8077-ca8bdc6d35bf",// �ڵ�ID���µ���
				NodeStatusDetail.COMPLETE_SUCCESS, 
				"0");
	}
	
	/**
	 * ��������ID���ڵ�ID������ʵ��ID���½ڵ�״̬(������µ��ɹ������������)
	 */
	public void success(String historyId) {
		FlowComponentFactory.getCompleteQueueSender().putCompleteNode(
				"FLOW_2", 
				historyId, 
				"16422cbb-ccb0-4fe2-952b-e3ad5c3acbb2",// �ڵ�ID���µ��ɹ���
				NodeStatusDetail.COMPLETE_SUCCESS, 
				"0");
	}
}
