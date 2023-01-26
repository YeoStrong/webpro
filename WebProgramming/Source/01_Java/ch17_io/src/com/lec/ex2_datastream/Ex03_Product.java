package com.lec.ex2_datastream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

// x�� �Է��� ������ ��� ���(���Ǹ�, ����, ������):file ��� -> x�� �Է��ϸ� �̶����� ��ϵ� ��� ��� ����� ���
public class Ex03_Product {
	public static void main(String[] args) {
		// x�� �Է��� ������ �����(���Ǹ�, ����, ������):file ���
		OutputStream 	 fos = null;
		DataOutputStream dos = null;
		Scanner scanner = new Scanner(System.in);
		try {
			fos = new FileOutputStream("src/com/lec/ex2_datastream/product.dat", true);
			dos = new DataOutputStream(fos);
			while(true) {
				System.out.println("�԰�� ��� �� �ֳ���?(�Է�:y/����:x) : ");
				if(scanner.next().trim().equalsIgnoreCase("x")) break;
				System.out.print("�԰�� ��ǰ��: ");
				dos.writeUTF(scanner.next());
				System.out.print("�԰�� ��ǰ ����: ");
				dos.writeInt(scanner.nextInt());
				System.out.print("�԰�� ��ǰ ���: ");
				dos.writeInt(scanner.nextInt());
			}
			System.out.println("��� ��� �Ϸ�");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			try {
				if(dos!=null)dos.close();
				if(fos!=null)fos.close();
			} catch (IOException e) {
				
			}// close
		}// ��� ��� try-catch-finally
		// x�� �Է��ϸ� ��ϵ� ��� ��� ����� ���
		ArrayList<Product> products = new ArrayList<Product>();
		InputStream 	fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("src/com/lec.ex2_datastream/product.dat");
			dis = new DataInputStream(fis);
			while(true) {
				String name = dis.readUTF();
				int    price = dis.readInt();
				int    stock = dis.readInt();
				products.add(new Product(name, price, stock));
//				Product product= new Product();
//				product.setName(dis.readUTF());
//				product.setPrice(dis.readInt());
//				product.setStock(dis.readInt());
//				products.add(product);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("��� ��� ����մϴ�.");
		} finally {
			try {
				if(dis!=null)dis.close();
				if(fis!=null)fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		} // try-catch
		if(products.isEmpty()) {
			System.out.println("��ϵ� ��� �����ϴ�.");   
		}else {
			System.out.println("��ǰ�� \t����\t������");
			for(Product product : products) {
				System.out.println(product);
			}
			System.out.println("�̻� " + products.size() + "���� ��� ��ǰ �Էµ�.");
		}
	}
}
