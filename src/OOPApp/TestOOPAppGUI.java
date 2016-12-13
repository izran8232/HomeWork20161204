package OOPApp;

/**
 * Created by izran on 12/13/2016.
 */
import java.text.NumberFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;
import java.nio.file.Paths;
import java.io.FileNotFoundException;


public class TestOOPAppGUI {
    private static int currentIndex=0;
    private static ArrayList<Book> bklist=null;

    private static JTextField txtTitle = null;
    private static JTextField txtPublisher = null;
    private static JTextField txtAuthor = null;
    private static JTextField txtType = null;
    //private static JTextField txtCost = null;
    private static JFormattedTextField txtCost = null;

    private static String path ="";

    private static void UpdateForm(Book bk){
        txtTitle.setText(bk.getTitle());
        txtPublisher.setText(bk.getPublisher());
        txtAuthor.setText(bk.getAuthor());
        txtType.setText(String.valueOf(bk.getTitle()));
        txtCost.setText(String.valueOf(bk.getCost()));
    }

    private static void UpdateBook(){
        int Cost = Integer.parseInt(txtCost.getText().replace(",",""));
        bklist.get(currentIndex).SetTitle(txtTitle.getText());
        bklist.get(currentIndex).SetPublisher(txtTitle.getText());
        bklist.get(currentIndex).SetAuthor(txtAuthor.getText());
        bklist.get(currentIndex).SetType(txtTitle.getText());
        bklist.get(currentIndex).SetCost(Cost);
    }


    private static void AddForm(){
        txtTitle.setText("");
        txtPublisher.setText("");
        txtAuthor.setText("");
        txtType.setText("");
        txtCost.setText("");
    }
    private static void BookForm(){
        JFrame frame = new JFrame("Books Form");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Title");
        lblTitle.setSize(300, 30);
        lblTitle.setLocation(5, 5);

        txtTitle = new JTextField();
        txtTitle.setSize(110, 20);
        txtTitle.setLocation(80, 8);
        //txtTitle.setText(ac.getFirstName());

        JLabel lblPublisher = new JLabel("Publisher");
        lblPublisher.setSize(300, 30);
        lblPublisher.setLocation(5, 30);

        txtPublisher = new JTextField();
        txtPublisher.setSize(110, 20);
        txtPublisher.setLocation(80, 35);
        //txtPublisher.setText(ac.getLastName());

        JLabel lblAuthor = new JLabel("Author");
        lblAuthor.setSize(300, 30);
        lblAuthor.setLocation(5, 55);

        txtAuthor = new JTextField();
        txtAuthor.setSize(110, 20);
        txtAuthor.setLocation(80, 65);
        //txtAuthor.setText(ac.getEmail());

        JLabel lblType = new JLabel("Type");
        lblType.setSize(300, 30);
        lblType.setLocation(5, 80);

        txtType = new JTextField();
        txtType.setSize(110, 20);
        txtType.setLocation(80, 86);
        //txtType.setText(String.valueOf(ac.getPhone()));

        JLabel lblCost = new JLabel("Cost");
        lblCost.setSize(300, 30);
        lblCost.setLocation(5, 110);


        NumberFormat longFormat = NumberFormat.getIntegerInstance();

        NumberFormatter numberFormatter = new NumberFormatter(longFormat);
        numberFormatter.setAllowsInvalid(false); //this is the key!!
        numberFormatter.setMinimum(0l); //Optional

        txtCost = new JFormattedTextField(numberFormatter);
        //txtCost = new JTextField();
        txtCost.setSize(110, 20);
        txtCost.setLocation(80, 116);




        JButton btn = new JButton("Save");
        btn.setSize(90,22);
        btn.setLocation(350, 380);

        contentPane.add(lblTitle);
        contentPane.add(txtTitle);
        contentPane.add(lblPublisher);
        contentPane.add(txtPublisher);
        contentPane.add(lblAuthor);
        contentPane.add(txtAuthor);
        contentPane.add(lblType);
        contentPane.add(txtType);

        contentPane.add(lblCost);
        contentPane.add(txtCost);

        JButton prevbtn = new JButton("Previous");
        JButton nextbtn = new JButton("Next");

        JButton btnnew = new JButton("New");
        JButton btncancel = new JButton("Cancel");
        JButton btnsave = new JButton("Save");
        JButton btnUpdate = new JButton("Update");

        prevbtn.setSize(90,22);
        prevbtn.setLocation(170, 180);
        prevbtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(currentIndex>-1){
                    currentIndex--;
                }
                if(currentIndex==-1 || currentIndex==0){
                    currentIndex=0;
                    prevbtn.setEnabled( false );
                }else{
                    prevbtn.setEnabled( true );
                }
                if(currentIndex<bklist.size())nextbtn.setEnabled( true );
                UpdateForm(bklist.get(currentIndex));
            }
        });
        contentPane.add(prevbtn);

        nextbtn.setSize(90,22);
        nextbtn.setLocation(50, 180);
        // add the listener to the jbutton to handle the "pressed" event
        nextbtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(currentIndex<=bklist.size()-1){
                    currentIndex++;
                }
                if(currentIndex>bklist.size()-1){
                    currentIndex--;
                    nextbtn.setEnabled( false );
                }else{
                    nextbtn.setEnabled( true );
                }
                if(currentIndex>0)prevbtn.setEnabled( true );
                UpdateForm(bklist.get(currentIndex));
            }
        });

        contentPane.add(nextbtn);






        contentPane.add(btncancel);
        btncancel.setSize(90,22);
        btncancel.setLocation(50, 180);
        btncancel.setVisible(false);
        btncancel.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                btnsave.setVisible(false);
                btncancel.setVisible(false);
                nextbtn.setVisible(true);
                prevbtn.setVisible(true);
                btnnew.setVisible(true);
                btnUpdate.setVisible(true);
                if(bklist.size()>0){
                    UpdateForm(bklist.get(currentIndex));
                }
            }
        });
        contentPane.add(btncancel);


        contentPane.add(btnsave);
        btnsave.setSize(90,22);
        btnsave.setLocation(170, 180);
        btnsave.setVisible(false);
        btnsave.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                int size=5;//Integer.parseInt(arrBook[0]);
                String Title = txtTitle.getText();
                String Publisher = txtPublisher.getText();
                String Author = txtAuthor.getText();
                String Type = txtType.getText();
                int Cost = Integer.parseInt(txtCost.getText().replace(",",""));//Integer.parseInt(String)
                Book bk = new Book(Title,Publisher,Author,Type,Cost);
                bklist.add(bk);
                bk.saveToFile(bklist,path );




                btnsave.setVisible(false);
                btncancel.setVisible(false);
                nextbtn.setVisible(true);
                prevbtn.setVisible(true);
                btnnew.setVisible(true);
                btnUpdate.setVisible(true);
            }
        });
        contentPane.add(btnsave);


        contentPane.add(btnnew);
        btnnew.setSize(90,22);
        btnnew.setLocation(330, 180);
        btnnew.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                btnsave.setVisible(true);
                btncancel.setVisible(true);

                nextbtn.setVisible(false);
                prevbtn.setVisible(false);
                btnnew.setVisible(false);
                btnUpdate.setVisible(false);
                AddForm();
            }
        });
        contentPane.add(btnnew);


        btnUpdate.setSize(90,22);
        btnUpdate.setLocation(430, 180);
        btnUpdate.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                UpdateBook();
                Book bk = new Book();
                bk.saveToFile(bklist,path );

            }
        });
        contentPane.add(btnUpdate);



        frame.setContentPane(contentPane);
        frame.setSize(750, 500);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }



    public static void main(String args[]) throws FileNotFoundException {

        path = Paths.get("src/OOPApp/Bookdata.csv").toAbsolutePath().normalize().toString();

        System.out.println(Paths.get("").toAbsolutePath().normalize().toString());
        Book bk = new Book();
        bklist=bk.getBookDataFromFile(path);
        BookForm();
        if(bklist.size()>0){
            UpdateForm(bklist.get(0));
        }

    }

}
