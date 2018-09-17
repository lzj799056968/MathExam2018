package mathExam6371;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
public class MathExam6371 {
	static int n1, n2;  //����������
    static int yunsuanfu;
    static int grade;
    static String[] Q,A;  //д��txt�ļ�����Ŀ�ʹ�
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		int n=Integer.parseInt(args[0]);
		//�жϴ������������
		try {
       	 n= Integer.parseInt(args[0]);
            if (n < 0) {
                System.out.println("��������Ϊ�������������У�");
                System.exit(0);
            } else if (n== 0 || n > 100) {
                System.out.println("��������ʵ���������1-100");
                System.exit(0);
            }
        } catch (NumberFormatException e) {
            System.out.println("���������������������У�");
            System.exit(0);
        }

		if(args.length<1||args.length>2) {
			System.out.println("������������������");
			System.exit(0);
		}
		writeTo();
	}
	
	public static void grade1(int n) {//һ�꼶��Ŀ
        int result = 0;
        for (int i = 1; i <= n; i++) {
        	n1 = (int)(Math.random()*(10+1));
        	yunsuanfu = (int)(Math.random()*2);
            	if (yunsuanfu == 0) {
            		n2 = (int)(Math.random()*(10+1));
            		result = n1 + n2;
            		// ��¼��Ŀ�ʹ�
            		Q[i-1] = "(" + i + ") " + n1 + " + " + n2 + " =";
            		A[i-1] = "(" + i + ") " + n1 + " + " + n2 + " = " + result;
            	} 
            	else if (yunsuanfu ==1) {
            		do {n2 = (int)(Math.random()*(10+1));}
            		while (n2 > n1);
            		result = n1 - n2;// ��¼��Ŀ�ʹ�
					Q[i-1] = "(" + i + ") " + n1 + " - " + n2 + " =";
					A[i-1] = "(" + i + ") " + n1 + " - " + n2 + " = " + result;
            }
        }
	}
	public static void grade2(int n) {//���꼶��Ŀ
        int result = 0;
        int yushu = 0;
        for (int i = 1; i <= n; i++) {
        	yunsuanfu = (int)(Math.random()*2);
            if (yunsuanfu == 0) {
            	n1 = (int)(Math.random()*10);
            	n2 = (int)(Math.random()*10);
            	result = n1 * n2;
                // ��¼��Ŀ�ʹ�
            	Q[i-1] = "(" + i + ") " + n1 + " * " + n2 + " =";
            	A[i-1] = "(" + i + ") " + n1 + " * " + n2 + " = " + result;
            } else if (yunsuanfu == 1) {
            	n1 = (int)(Math.random()*10+1);
                do {
                	n2 = (int)(Math.random()*10+1);
                } while (n2 <= (n1 / 10) || n2 == 0);
                result = n1 / n2;
                yushu = n1 % n2;
                // ��¼��Ŀ�ʹ�
                Q[i-1] = "(" + i + ") " + n1 + " / " + n2 + " =";
                if (yushu == 0) {
                	A[i-1] = "(" + i + ") " + n1 + " / " + n2 + " = " + result;
                } else {
                	A[i-1] = "(" + i + ") " + n1 + " / " + n2 + " = " + result + "..." + yushu;
                }
            }
        }
	}
    public static void writeTo() throws IOException {//���
  	  File file= new File("out.txt");
		if (!file.exists()) {
			File parent = file.getParentFile();
			if (parent != null && !parent.exists()) {
				parent.mkdirs();
			}
			file.createNewFile();
		}
		OutputStream out = new FileOutputStream(file);
		byte[] q=Q.toString().getBytes();
		byte[] a=A.toString().getBytes();
		out.write(q);
		out.write(System.lineSeparator().getBytes());
		out.write(a);
		out.close();
  }
}

