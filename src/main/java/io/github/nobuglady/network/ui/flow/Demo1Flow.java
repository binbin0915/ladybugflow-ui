package io.github.nobuglady.network.ui.flow;

import org.springframework.stereotype.Component;

import io.github.nobuglady.network.fw.FlowRunner;
import io.github.nobuglady.network.fw.annotation.Node;

@Component
public class Demo1Flow extends FlowRunner {

	@Node(label = "start")
	public void processStart() throws InterruptedException {
		System.out.println("������ʼ ��ģ��ҵ��ȴ�3�룩");
		Thread.sleep(3000);
		System.out.println("��������");
	}

	@Node(label = "��ѯ�û���Ϣ")
	public void processSearchUser() throws InterruptedException {
		System.out.println("��ѯ�û���Ϣ��ʼ ��ģ��ҵ��ȴ�3�룩");
		Thread.sleep(3000);
		System.out.println("��ѯ�û���Ϣ����");
	}

	@Node(label = "��ѯ�Ƶ���Ϣ")
	public void processSearchHotel() throws InterruptedException {
		System.out.println("��ѯ�Ƶ���Ϣ��ʼ ��ģ��ҵ��ȴ�3�룩");
		Thread.sleep(3000);
		System.out.println("��ѯ�Ƶ���Ϣ����");
	}

	@Node(label = "�µ�")
	public void processOrder() throws InterruptedException {
		System.out.println("�µ���ʼ ��ģ��ҵ��ȴ�3�룩");
		Thread.sleep(3000);
		System.out.println("�µ�����");
	}

	@Node(label = "�µ��ɹ�")
	public void processSuccess() throws InterruptedException {
		System.out.println("�µ��ɹ���ʼ ��ģ��ҵ��ȴ�3�룩");
		Thread.sleep(3000);
		System.out.println("�µ��ɹ�����");

	}
}