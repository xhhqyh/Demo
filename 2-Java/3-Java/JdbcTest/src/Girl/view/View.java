package Girl.view;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Girl.action.GoddessAction;
import Girl.model.Goddess;

/**
 * ��ͼ�㣺�ò���Ҫ���2������
 * 		1����ô�ó���һֱ����
 * 			whileѭ����scan.hasNext()�����ǵ�������ʱһֱѭ��������ѭ��
 * 		2����ô��֤һ��������������ִ����������
 * 			* ����һ��������Ȼ��һ��������
 * 			* ����һ����������ǵ�ǰ���ܲ���
 * @author С�һ�
 */
public class View {
	//��ʾ��
	private static final String CONTEXT="��ӭ����Ů��˿����:\n" +
										"[M]:���˵�\n" +
										"[Q]:�鿴ȫ��Ů��˿����Ϣ\n" +
										"[G]:�鿴ĳλŮ��˿����ϸ��Ϣ\n" +
										"[S]:��������ģ����ѯŮ��˿��Ϣ\n" +
										"[A]:���Ů��˿��Ϣ\n" +
										"[U]:����Ů��˿��Ϣ\n" +
										"[D]:ɾ��Ů��˿��Ϣ\n" +
										"[B]:�˳���ǰ���ܣ��������˵�\n" +
										"[E]:�˳�Ů��˿����\n" +
										"��������Ҫ�������Ŀ:";
	
	//�������
	private static final String OPERATION_MIAN="MAIN";
	private static final String OPERATION_QUERY="QUERY";
	private static final String OPERATION_GET="GET";
	private static final String OPERATION_ADD="ADD";
	private static final String OPERATION_UPDATE="UPDATE";
	private static final String OPERATION_DELETE="DELETE";
	private static final String OPERATION_SEARCH="SEARCH";
	private static final String OPERATION_EXIT="EXIT";
	private static final String OPERATION_BREAK="BREAK";
	
	public static void main(String[] args) throws SQLException {
		System.out.println(CONTEXT);
		
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		Goddess goddess=new Goddess();
		GoddessAction action=new GoddessAction();
		//����һ���������,������һ�����������һ��ģ��
		String prenious=null;
		//������
		Integer step=1;
		
		//whileѭ����scan.hasNext()�����ǵ�������ʱһֱѭ��������ѭ��
		while(scan.hasNext()){
			String in=scan.next().toString();
			//�˳�Ů��˿����
			if(OPERATION_EXIT.equals(in.toUpperCase()) || OPERATION_EXIT.substring(0, 1).equals(in.toUpperCase())){
				System.out.println("���Գɹ��˳�Ů��˿����");
				break;
			}
			
			//���ص�ǰ���˵�
			if(OPERATION_MIAN.equals(in.toUpperCase()) || OPERATION_MIAN.substring(0, 1).equals(in.toUpperCase())){
				step = 1;
				prenious = null;
				System.out.println(CONTEXT);
			}
			
			//�˳���ǰ���ܣ��������˵�
			if(OPERATION_BREAK.equals(in.toUpperCase()) || OPERATION_BREAK.substring(0, 1).equals(in.toUpperCase())){
				//���ص�ǰ���˵�
				step = 1;
				prenious = null;
				System.out.println(CONTEXT);
			}
			
			//�鿴ȫ��Ů��˿����
			if(OPERATION_QUERY.equals(in.toUpperCase()) || OPERATION_QUERY.substring(0, 1).equals(in.toUpperCase())){
				try {
					List<Goddess> list=action.query();
					//Ȼ�󽫷����������
					for (Goddess goddess2 : list) {
						System.out.println("���:" + goddess2.getId()+ " ����:"+goddess2.getUser_name());
					}
					System.out.println("��������Ҫ�������Ŀ:");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//�鿴ĳλŮ�����ϸ��Ϣ
			if(OPERATION_GET.equals(in.toUpperCase()) || OPERATION_GET.substring(0, 1).equals(in.toUpperCase())
					|| OPERATION_GET.equals(prenious)){
				prenious=OPERATION_GET;
				if(1==step){
					System.out.println("������Ҫ�鿴Ů��˿��[ID]:");
				}else if(2==step){
					try {
						goddess=action.get(Integer.valueOf(in));
						if (goddess != null) { 
							step = 1;
							prenious = null;
							System.out.println("��ţ�" + goddess.getId() +
									"\n������" + goddess.getUser_name() +
									"\n�Ա�" + (goddess.getSex() == 1 ? "Ů":"��") +
									"\n���䣺" + goddess.getAge() + "\n���գ�" +
									goddess.getBirthday() + "\n���䣺" +
									goddess.getEmail() + "\n�ֻ��ţ�" +
									goddess.getMobile()); 
						}else {
							step = 1; 
							prenious = null; 
							System.out.println("��ѯ��Ů�񲻴��ڣ�"); 
						}
					} catch (NumberFormatException e) {
						step = 1;
						prenious = null;
						System.out.println("��������ȷ��Ů��˿[ID]:");
					} catch (Exception e) {
						e.printStackTrace();
						step = 1;
						prenious = null;
						System.out.println("��ѯŮ��˿��ϸ��Ϣʧ��!!!");
					}
				}
				//������1
				if(OPERATION_GET.equals(prenious)){
					step++;
				}
			}
			
			//����������ģ����ѯ
			if(OPERATION_SEARCH.equals(in.toUpperCase()) || OPERATION_SEARCH.substring(0, 1).equals(in.toUpperCase())
					|| OPERATION_SEARCH.equals(prenious)){
				prenious=OPERATION_SEARCH;
				if(1==step){
					System.out.println("������Ҫ��ѯ��Ů��˿���������Բ鿴��ϸ��Ϣ��");
				}else if(2==step){
					List<Map<String, Object>> params=new ArrayList<Map<String, Object>>();
					
					Map<String, Object> map=new HashMap<String, Object>();
					//׷�ӵ�SQL����ֶ�
					map.put("name", "user_name");
					map.put("rela", "=");
					map.put("value", "'"+in+"'");
					
					params.add(map);
					List<Goddess> result;
					try {
						result = action.queryname(params);
						for(int i=0; i<result.size(); i++){
							System.out.println("��ţ�" + result.get(i).getId() +
									"\n������" + result.get(i).getUser_name() +
									"\n�Ա�" + (result.get(i).getSex() == 1 ? "Ů":"��") +
									"\n���䣺" + result.get(i).getAge() + "\n���գ�" +
									result.get(i).getBirthday() + "\n���䣺" +
									result.get(i).getEmail() + "\n�ֻ��ţ�" +
									result.get(i).getMobile()); 
						}
					} catch (Exception e) {
						e.printStackTrace();
						step = 1;
						prenious = null;
						System.out.println("��ѯŮ��˿��Ϣʧ��");
					}
				}
				if(OPERATION_SEARCH.equals(prenious)){
					step++;
				}
			}
			
			//����Ů��˿
			if(OPERATION_ADD.equals(in.toUpperCase()) || OPERATION_ADD.substring(0, 1).equals(in.toUpperCase())
					|| OPERATION_ADD.equals(prenious)){
				prenious=OPERATION_ADD;
				if(1==step){
					System.out.println("������Ů��˿��[����]");
				}else if(2==step){
					goddess.setUser_name(in);
					System.out.println("������Ů��˿��[����]");
				}else if(3==step){
					goddess.setAge(Integer.valueOf(in));
					System.out.println("������Ů��˿[����],��ʽ��yyyy-MM-dd");
				}else if(4==step){
					SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
					Date birthday=null;
					try {
						birthday = sf.parse(in);
						goddess.setBirthday(birthday);
						System.out.println("������Ů��˿��[����]");
					} catch (ParseException e) {
						e.printStackTrace();
						System.out.println("������ĸ�ʽ��������������");
						step=3;
					}
				}else if(5==step){
					goddess.setEmail(in);
					System.out.println("������Ů��˿��[�ֻ���]");
				}else if(6==step){
					goddess.setMobile(in); 
					
					try {
						action.add(goddess);
						System.out.println("����Ů��˿�ɹ�");
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("����Ů��˿ʧ��");
					}
				}
				
				if(OPERATION_ADD.equals(prenious)){
					step++;
				}
			}
			
			//Ů��˿���¹���	
			if(OPERATION_UPDATE.equals(in.toUpperCase()) || OPERATION_UPDATE.substring(0, 1).equals(in.toUpperCase())
					|| OPERATION_UPDATE.equals(prenious)){

				prenious = OPERATION_UPDATE;
				if(1==step){
					System.out.println("������Ҫ�޸ĵ�Ů��˿��[ID]:");
				}else if(2==step){
					try{
						Integer id = Integer.valueOf(in);
						goddess = action.get(id);
						if(goddess == null){
							step = 1;
							System.out.println("��Ҫ���µ�"+ id +"��Ů��˿������");
						}
					}catch (NumberFormatException e){
						step = 1;
						System.out.println("��������ȷ��Ů��˿[ID]��");
					}catch (Exception e){
						step = 1;
						System.out.println("��Ҫ���µ�[ID]Ů��˿������");
					}
					
					System.out.println("������Ů��˿[����],�粻���´��ֶΣ�����null");
				}else if(step == 3){
					if(!"null".equalsIgnoreCase(in)){
						goddess.setUser_name(in);
					}
					
					System.out.println("������Ů��˿[����],�粻���´��ֶΣ�����null");
				}else if(step == 4){
					try {
						if(!"null".equalsIgnoreCase(in)){
							Integer age = Integer.valueOf(in);
							goddess.setAge(age);
						}
					} catch (NumberFormatException e) {
						step = 3;
						System.out.println("��������ȷ��Ů��˿[����]:");
					}
					System.out.println("������Ů��[����]����ʽΪyyyy-MM-dd��(�粻���¸��ֶΣ�������null)");
				}else if(step == 5){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					try {
						if (!"null".equalsIgnoreCase(in)) { 
							goddess.setBirthday(sdf.parse(in));
						}
						System.out.println("������Ů��[����]��(�粻���¸��ֶΣ�������null)"); 
					} catch (ParseException e) { 
						step = 4; 
						System.out.println("��������ȷ��Ů���[����]��"); 
					}
				}else if (step == 6){
					if(!"null".equalsIgnoreCase(in)){
						goddess.setEmail(in);
					}
					System.out.println("������Ů��[�ֻ���],��������´�������null��");
				}else if (step == 7){
					if(!"null".equalsIgnoreCase(in)){
						goddess.setMobile(in);
					}
					
					try {
						action.edit(goddess);
						System.out.println("����Ů��˿��Ϣ�ɹ���");
						step = 1;
						prenious = null;
					} catch (Exception e) {
						e.printStackTrace();
						step = 1;
						prenious = null;
						System.out.println("����Ů��˿��Ϣʧ�ܣ�");
					}
				}
				if(OPERATION_UPDATE.equals(prenious)){
					step++;
				}
			}
			
			//ɾ��Ů��˿����
			if(OPERATION_DELETE.equals(in.toUpperCase()) || OPERATION_DELETE.substring(0, 1).equals(in.toUpperCase())
					|| OPERATION_DELETE.equals(prenious)){
				prenious = OPERATION_DELETE;
				if(step == 1){
					System.out.println("������Ҫɾ����Ů��˿��[ID]:(ɾ������ö��Ÿ�������1,2,...)");
				}else if(step == 2){
					try {
						String[]  ss = in.split(",");
						Integer[] ids = new Integer[ss.length];
						for(int i=0; i<ss.length; i++){
							ids[i] = Integer.parseInt(ss[i]);
						}
						action.del(ids);
						System.out.println("ɾ��Ů��˿�ɹ�!");
						step = 1;
						prenious = null;
					} catch (NumberFormatException e) {
						step = 1;
						System.out.println("��������ȷ��Ů��˿[ID]");
					} catch (Exception e) {
						e.printStackTrace();
						step = 1;
						prenious = null;
						System.out.println("ɾ��Ů��˿ʧ��");
					}
					
				}
				if(OPERATION_DELETE.equals(prenious)){
					step++;
				}
			}
		}
	}
}
