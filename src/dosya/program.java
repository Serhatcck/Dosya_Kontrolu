package dosya;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class program {
	
	static String path = "/root/eclipse-workspace/dosya/src/dosya";
	
	public static void paket_kaydi(String seriNo ,String tur,String boyut , String desi) throws IOException
	{
		File dosya = new File(path + "/Depo.txt");
		BufferedReader br = new BufferedReader(new FileReader(dosya));
		FileWriter yazici = new FileWriter(dosya,true);
        BufferedWriter yaz = new BufferedWriter(yazici);
		
		
		ArrayList<Paket> paketler = new ArrayList<Paket>();
		String veri;
		while((veri = br.readLine()) != null) {
			String data[] = veri.split(" ");
			
			paketler.add(new Paket(data[0], data[1], data[2], data[3]));
		}
		System.out.println("Paket Sayisi: "+paketler.size());
		paketler.add(new Paket(seriNo,tur,boyut,desi));
		int i = paketler.size();
		i -= 1;
		Paket pkt = paketler.get(i);
		yaz.write(pkt.SeriNo);//Calismiyor
		yaz.write(pkt.Tur);//Calismiyor
		System.out.println("Paket Eklendi\nPaket Sayisi: "+paketler.size());
	}
	
	
	public static void paket_oku() throws IOException {
		File dosya = new File(path + "/Depo.txt");
		BufferedReader br = new BufferedReader(new FileReader(dosya));
		
		ArrayList<Paket> paketler = new ArrayList<Paket>();
		String veri;
		while((veri = br.readLine()) != null) {
			String data[] = veri.split(" ");
			
			paketler.add(new Paket(data[0], data[1], data[2], data[3]));
		}
		
		System.out.println("Paket Sayisi: "+paketler.size());
		
		for(int i=0; i<paketler.size(); i++) {
			Paket pkt = paketler.get(i);
			System.out.println(pkt.SeriNo + "\t" + pkt.Desi);
		}
		
		/*
		 * Kullanıcının aktarmak istediği paketleri generic listeye ata.
		 * listenin size'ı kadar for döngüsü ile nesneyi txt ye yaz.
		 * */
		br.close();
	}

	public static void arac_oku() throws IOException {
		File dosya = new File(path + "/22AH457.txt");
		BufferedReader br = new BufferedReader(new FileReader(dosya));
		
		ArrayList<Arac> paketler = new ArrayList<Arac>();
		String veri;
		while((veri = br.readLine()) != null) {
			String data[] = veri.split(" ");
			
			paketler.add(new Arac(data[0], data[1], data[2], data[3]));
		}
		
		System.out.println("Paket Sayisi: "+paketler.size());
		
		for(int i=0; i<paketler.size(); i++) {
			Arac pkt = paketler.get(i);
			System.out.println(pkt.Plaka + "\t" + pkt.MaxDesi);
		}
		
		/*
		 * Kullanıcının aktarmak istediği paketleri generic listeye ata.
		 * listenin size'ı kadar for döngüsü ile nesneyi txt ye yaz.
		 * */
		br.close();
	}
	
	
	
	public static void main(String Args[]) {
		/*try {
			paket_oku();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
JFrame frame = new JFrame();
		
		JPanel gui  = new JPanel();
		gui.setLayout(null);
		
		JPanel dugmeler = new JPanel();
		dugmeler.setLayout(null);
		dugmeler.setLocation(10,10);
		dugmeler.setSize(250,275);
		gui.add(dugmeler);
		
		JButton jb1 = new JButton();
		jb1.setText("Paket Ekle");
		jb1.setSize(170,20);
		jb1.setLocation(70,20);
		jb1.setHorizontalAlignment(4);
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String seri_no= JOptionPane.showInputDialog("Paket numarasini girinz");
				String tur = JOptionPane.showInputDialog("Paket turunu girinz"); 
				String icerik = JOptionPane.showInputDialog("Paket icerigini girinz");
				int desi_oz = Integer.parseInt(JOptionPane.showInputDialog("Paketin enini giriniz"));
				int  desi_oz1 = Integer.parseInt(JOptionPane.showInputDialog("Paketin boyunu giriniz"));
				int  desi_oz2 = Integer.parseInt(JOptionPane.showInputDialog("Paketin yuksekligini giriniz"));
				int  desi_oz3 = (desi_oz*desi_oz1*desi_oz2)/3000;
				String desi = String.valueOf(desi_oz3);
				try {
				paket_kaydi(seri_no,tur,icerik,desi);
				} catch (IOException c) {
				// TODO Auto-generated catch block
				c.printStackTrace();
				}
				
			}
		});
		dugmeler.add(jb1);
		
		frame.setSize(300,300);
		frame.setContentPane(gui);
		frame.setLocation(500,250);
		frame.setResizable(false);
		frame.setVisible(true);
		
		
		
		
		
		
		
		
		
		
		
	}
}
