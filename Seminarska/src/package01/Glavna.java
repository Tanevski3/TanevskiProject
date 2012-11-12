package package01;
//kako so se pisi kodot taka vklucuvame se ostanato
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Properties;

/*									UNIVERZITET "SVETI KLIMENT OHRIDSKI"
 *										TEHNICKI FAKULTET - BITOLA
 *
 *								Otsek za Informatika i Kompjuterska tehnika
 *
 *									Objektno orientirano programiranje
 *			 								Seminarska rabota
 *
 *				***********************					*****					*****************
 *				***********************					*****					*****************
 *						*****							*****					*****
 *						*****						*************				*****
 *						*****					*****	*****	*****			*****	
 *						*****					*****	*****	*****			***************	
 *						*****						*************				********************
 *						*****							*****					*****		*********
 *						*****							*****					*****		*******
 *						*****							*****					*****************
 *						*****							*****					*************
 *
 *
 *									Emajler-programa za kreiranje na e-mail
 *
 *
 *
 * Izrabotil:                                   Profesor:                                      Assistent:
 * Marjan Tanevski 1765					      Ilija Jolevski								Tome Nedanovski            */



public class Glavna{  


	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		final JFrame fGlaven_prozorec=new JFrame("E majler™");//tuka go sozdavame nasiot gl. prozorec
		fGlaven_prozorec.setVisible(true);//prozorecot da e vidliv
		fGlaven_prozorec.setSize(600, 700);//sirinata i visinata na gl. prozorec

		fGlaven_prozorec.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Pravilno zatvoranje na gl. prozorec
/***/
		JMenuBar mGlavno_meni=new JMenuBar();//gornata lenta potrebna za oddelnite menia
		fGlaven_prozorec.setJMenuBar(mGlavno_meni);
/***/
		JMenu mFile_meni=new JMenu("E majler"); //meni File
		mGlavno_meni.add(mFile_meni);
		JMenuItem miReset_podmeni=new JMenuItem("Resetiraj");//podmeni Reset
		mFile_meni.add(miReset_podmeni);
		JMenuItem miExit_podmeni=new JMenuItem("Izlez");//podmeni Exit
		mFile_meni.add(miExit_podmeni);
miExit_podmeni.addActionListener(new Exit_Action());

/***/
		JMenu mHelp_meni=new JMenu("Pomos"); //meni File
		mGlavno_meni.add(mHelp_meni);
		JMenuItem miAbout_podmeni=new JMenuItem("Sa...");//podmeni Exit
		mHelp_meni.add(miAbout_podmeni);
		
		class About_Action implements ActionListener {
			
			public void actionPerformed(ActionEvent ae) {


				JOptionPane.showMessageDialog(fGlaven_prozorec,"Програма: Е-мајлер"+"\n"+"Верзија:1.0.0 "+ "\n"+" © Авторски права Марјан Таневски,  асс. Томе Недановски, проф. Илија Јолевски и останати. Сите права се задржани."+"\n"+" Овај продукт  е развиен благодарение на Технички Факултет-Битола.");

	

		}
		}
		
miAbout_podmeni.addActionListener(new About_Action()); 

/** **/

		JPanel pGlaven_panel=new JPanel(new GridBagLayout());
		fGlaven_prozorec.getContentPane().add(pGlaven_panel,BorderLayout.SOUTH);
		GridBagConstraints c1= new GridBagConstraints();
		fGlaven_prozorec.add(pGlaven_panel);
		
		JLabel lIme_labela=new JLabel("Вашето име:");
		c1.gridx=0;
		c1.gridy=0;
		pGlaven_panel.add(lIme_labela,c1);
		
		final TextField tIme = new TextField("Ime",10);
		c1.gridx=1;
		c1.gridy=0;
		pGlaven_panel.add(tIme,c1);
		
class text_Action implements TextListener { //sto ke se sluci sekogas koga ke bidi pritisnato podmenito reset

			
			public void textValueChanged(TextEvent te)  {
				if(tIme.getText().equals("")) //meni go tekovniot text vo ""
				{
				JOptionPane.showMessageDialog(fGlaven_prozorec,"е-Мајлот не е креиран.  ","Креирањето на xml документот беше неуспешно", JOptionPane.WARNING_MESSAGE);
				}
			
				}
				


			
		}

tIme.addTextListener(new text_Action());
		JLabel lPrezime_labela=new JLabel("Вашето презиме:");
		c1.gridx=0;
		c1.gridy=1;		
		pGlaven_panel.add(lPrezime_labela,c1);
		
		
		
		
		final TextField tPrezime = new TextField("Презиме",15);
		c1.gridx=1;
		c1.gridy=1;	
		pGlaven_panel.add(tPrezime,c1);

		JLabel lPol_labela=new JLabel("Пол:");
		c1.gridx=0;
		c1.gridy=2;		
		pGlaven_panel.add(lPol_labela,c1);
		
		JLabel lMarjan_labela=new JLabel("Marjan");
		c1.gridx=0;
		c1.gridy=3;		
		pGlaven_panel.add(lMarjan_labela,c1);
		
		JLabel ltanevski_labela=new JLabel("Tanevski");
		c1.gridx=0;
		c1.gridy=4;		
		pGlaven_panel.add(lTanevski_labela,c1);
		


final List lPol = new List(2, false);

lPol.add("Maшки");
lPol.add("Женски");
                c1.gridx=1;
        		c1.gridy=2;
pGlaven_panel.add(lPol,c1);

JLabel lGodina_rag_labela=new JLabel("Дата на раѓање:");
c1.gridx=0;
c1.gridy=3;		
pGlaven_panel.add(lGodina_rag_labela,c1);

JLabel lData_dat_labela=new JLabel("Data");
c1.gridx=2;
c1.gridy=3;		
pGlaven_panel.add(lData_dat_labela,c1);

final TextField tData = new TextField("09.29.2009");
c1.gridx=1;
c1.gridy=3;	
pGlaven_panel.add(tData,c1);

JLabel lDrz_labela=new JLabel("Држава:");
c1.gridx=0;
c1.gridy=4;		
pGlaven_panel.add(lDrz_labela,c1);

final List lDrzava = new List(8, false);

lDrzava.add("Македонија");
lDrzava.add("Романија");
lDrzava.add("Русија");
lDrzava.add("Англија");
lDrzava.add("Америка");
lDrzava.add("Франција");
lDrzava.add("Германија");
lDrzava.add("Египет");
c1.gridx=1;
c1.gridy=4;	
pGlaven_panel.add(lDrzava,c1);

JLabel lJazik_labela=new JLabel("Јазик:");
c1.gridx=0;
c1.gridy=5;		
pGlaven_panel.add(lJazik_labela,c1);

final List lJazik = new List(2, false);
lJazik.add("Македонски");
lJazik.add("Англиски");
c1.gridx=1;
c1.gridy=5;	
pGlaven_panel.add(lJazik,c1);


JLabel lMajl_labela=new JLabel("Мајл:");
c1.gridx=0;
c1.gridy=6;		
pGlaven_panel.add(lMajl_labela,c1);

final List lMajl = new List(7, false);
lMajl.add("@gmail.com");
lMajl.add("@yahoo.com");
lMajl.add("@yahoomail.com");
lMajl.add("@rocketmail.com");
lMajl.add("@live.com");
lMajl.add("@hotmail.com");
lMajl.add("@mymail.com");
c1.gridx=1;
c1.gridy=6;	
pGlaven_panel.add(lMajl,c1);

JLabel lpLozinka_labela=new JLabel("Лозинка:");
c1.gridx=0;
c1.gridy=7;		
pGlaven_panel.add(lpLozinka_labela,c1);

JPasswordField pLozinka = new JPasswordField("", 10);
c1.gridx=1;
c1.gridy=7;	
pGlaven_panel.add(pLozinka,c1);

System.out.println("Zdravo jas se vikam Marjan");//asdasdasdasd

JLabel lPrazna_labela=new JLabel("                 ");
c1.gridx=0;
c1.gridy=8;		
pGlaven_panel.add(lPrazna_labela,c1);


                Button bVnesi_button = new Button("      Внеси      ");
        		c1.gridx=1;
        		c1.gridy=9;	
        		pGlaven_panel.add(bVnesi_button,c1);
				
				Button bUnesi_button = new Button("    Unesi   ");
        		c1.gridx=1;
        		c1.gridy=10;	
        		pGlaven_panel.add(bUnesi_button,c1);
				
				Button bBrisi_button = new Button("   Brisi  ");
        		c1.gridx=1;
        		c1.gridy=11;	
        		pGlaven_panel.add(bBrisi_button,c1);
		
		final JPanel pDol_panel=new JPanel(new GridBagLayout());
		fGlaven_prozorec.getContentPane().add(pGlaven_panel,BorderLayout.NORTH);
		final GridBagConstraints c2= new GridBagConstraints();
		fGlaven_prozorec.add(pDol_panel);
		
		JLabel lRezultat_labela=new JLabel("Резултат:");
		c2.gridx=0;
		c2.gridy=1;		
		pDol_panel.add(lRezultat_labela,c2);
		
		final TextField tRezultat = new TextField(30);
		c2.gridx=1;
		c2.gridy=1;	
		pDol_panel.add(tRezultat,c2);
		
		JLabel lEmajl_labela=new JLabel("Вашиот е-мајл:  ");
		c2.gridx=0;
		c2.gridy=2;		
		pDol_panel.add(lEmajl_labela,c2);

		final TextField tEmajl = new TextField(30);
		c2.gridx=1;
		c2.gridy=2;	
		pDol_panel.add(tEmajl,c2);
		
		final Button bIsprati_button = new Button("      Испрати на мајл      ");
		c2.gridx=1;
		c2.gridy=3;	
		pDol_panel.add(bIsprati_button,c2);

tEmajl.disable();
bIsprati_button.disable();




	
class Reset_Action implements ActionListener { //sto ke se sluci sekogas koga ke bidi pritisnato podmenito reset

			
			public void actionPerformed(ActionEvent ae1) {
				
				tIme.setText(""); //meni go tekovniot text vo ""
				tPrezime.setText("");
				tRezultat.setText("");
				tData.setText("");
				
			}

		}

miReset_podmeni.addActionListener(new Reset_Action());

		class Vnesi_button_action implements ActionListener{
			public void actionPerformed(ActionEvent ae2)
			{
				if(tIme.getText().equals(""))
				{
					JOptionPane.showMessageDialog(fGlaven_prozorec,"е-Мајлот не е креиран.  ","Креирањето на xml документот беше неуспешно", JOptionPane.WARNING_MESSAGE);
				
				}
				tRezultat.setText(tIme.getText()+"."+tPrezime.getText()+lMajl.getSelectedItem());
				/**//*KREIRANJETO NA XML DOCUMENT ZAPOCNUVA TUKA*//**/
				 try{
				        DocumentBuilderFactory dbfMajl_docFactory=DocumentBuilderFactory.newInstance();
				        DocumentBuilder dbMajl_doc=dbfMajl_docFactory.newDocumentBuilder();
				        Document dMajl_document=dbMajl_doc.newDocument();
				        
				        Element eKoren=dMajl_document.createElement("Korisnik");
				        dMajl_document.appendChild(eKoren);
				        
				        //Ime
				        Element eIme= dMajl_document.createElement("Ime");
				        eKoren.appendChild(eIme);
				        eIme.appendChild(dMajl_document.createTextNode(tIme.getText()));//tekstot vo imeto
				        
				        //Prezime
				        Element ePrezime= dMajl_document.createElement("Prezime");
				        eKoren.appendChild(ePrezime);
				        ePrezime.appendChild(dMajl_document.createTextNode(tPrezime.getText()));//tekstot vo prezimeto
				        
				        //Pol
				        Element ePol=dMajl_document.createElement("Pol");
				        eKoren.appendChild(ePol);
				        ePol.appendChild(dMajl_document.createTextNode(lPol.getSelectedItem()));//selektiranata opcija od listata za pol
				        
				        //Data na raganje
				        Element eData_na_raganje=dMajl_document.createElement("Data_na_raganje");
				        eKoren.appendChild(eData_na_raganje);
				        eData_na_raganje.appendChild(dMajl_document.createTextNode(tData.getText()));//tekstot vo datata
				        
				        //Drzava
				        Element eDrzava=dMajl_document.createElement("Drzava");
				        eKoren.appendChild(eDrzava);
				        eDrzava.appendChild(dMajl_document.createTextNode(lDrzava.getSelectedItem()));//selektriranata opcija od listata za drzavi
				        
				        //Jazik
				        Element eJazik=dMajl_document.createElement("Jazik");
				        eKoren.appendChild(eJazik);
				        eJazik.appendChild(dMajl_document.createTextNode(lJazik.getSelectedItem()));// selektiranata opcija od listata za jazici
				        
				      //Majl
				        Element eMajl=dMajl_document.createElement("Majl");
				        eKoren.appendChild(eMajl);
				        eMajl.appendChild(dMajl_document.createTextNode(lMajl.getSelectedItem()));// selektiranata opcija od listata za majl
				        
				       //TransformFactory
				        TransformerFactory tfMajl_transformerFactory = TransformerFactory.newInstance();
				        Transformer tMajl_transformer=tfMajl_transformerFactory.newTransformer();
				        DOMSource domsIzvor=new DOMSource(dMajl_document);
				    
				        StreamResult srRezultat=new StreamResult(new File("emajler_vnatresno.xml"));
				    
				        tMajl_transformer.transform(domsIzvor, srRezultat);
				        tEmajl.enable();
				        bIsprati_button.enable();
}
				    catch(Exception eIsklucok)
				    {
				    	JOptionPane.showMessageDialog(fGlaven_prozorec,"е-Мајлот не е креиран.  "+eIsklucok,"Креирањето на xml документот беше неуспешно", JOptionPane.WARNING_MESSAGE);
				    	
				    }
				/**//*KREIRANJETO NA XML DOCUMENT ZAVRSUVA TUKA*//**/
				}
			  }

		bVnesi_button.addActionListener(new Vnesi_button_action());
		
		class Isprati_button_action implements ActionListener{
			public void actionPerformed(ActionEvent ae3)
			{
				
				String host = "smtp.gmail.com";
				String isprakac = "tanevski.inc";
				String pas = "incorporated";
				Properties props = System.getProperties();
				props.put("mail.smtp.starttls.enable", "true"); 
				props.put("mail.smtp.host", host);
				props.put("mail.smtp.user", isprakac);
				props.put("mail.smtp.password", pas);
				props.put("mail.smtp.port", "587");
				props.put("mail.smtp.auth", "true");

				String[] primac = {tEmajl.getText()}; 

					
				Session session = Session.getDefaultInstance(props, null);
				MimeMessage message = new MimeMessage(session);
				try {
					
				message.setFrom(new InternetAddress(isprakac));

				InternetAddress[] toAddress = new InternetAddress[primac.length];

				
				
				    toAddress[0] = new InternetAddress(primac[0]);
				

				System.out.println(Message.RecipientType.TO);

				for( int i=0; i < toAddress.length; i++) { 
				    message.addRecipient(Message.RecipientType.TO, toAddress[i]);
				}
				message.setSubject("Vasiot e-majl e kreiran...");
				message.setText("E-majl: "+tRezultat.getText()+"\n "+"Ime: "+tIme.getText()+"\n "+"Prezime: "+tPrezime.getText()+"\n ");
				message.setFileName("emajler_vnatresno.xml");
				Transport transport = session.getTransport("smtp");
				transport.connect(host, isprakac, pas);
				transport.sendMessage(message, message.getAllRecipients());
				transport.close();
					}
				catch (Exception e2) {
					System.out.println("Greska:   "+e2);
				}
				
			}
		}
		
		bIsprati_button.addActionListener(new Isprati_button_action());
/***/

	}

}
