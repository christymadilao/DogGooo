package ui;


import model.AddressBook;
import model.Location;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Observable;

//Reference: https://www.youtube.com/watch?v=iE8tZ0hn2Ws

public class GUI extends Observable implements ActionListener {
    private AddressBook addressBook;
    private static JPanel panel;
    private static JLabel addLocationLabel;
    private static JLabel locationLabel;
    private static JTextField locationText;
    private static JLabel addressLabel;
    private static JTextField addressText;
    private static JLabel phoneLabel;
    private static JTextField phoneText;
    private static JLabel categoryLabel;
    private static JTextField categoryText;
    private static JButton addButton;
    private static JLabel searchLocationLabel;
    private static JLabel searchLabel;
    private static JTextField searchText;
    private static JButton searchButton;
    private static JLabel removeLocationLabel;
    private static JLabel removeLabel;
    private static JTextField removeText;
    private static JButton removeButton;
    private static JButton saveButton;
    private static JButton loadButton;
    private static JLabel image;

    public GUI() {

    }

    public JPanel createPanel() {

        panel = new JPanel();
        panel.setLayout(null);

    }

    public JPanel addLocationPanel() {

        //Add Location Components
        //how to make add location show in full
        addLocationLabel = new JLabel("Add Location");
        addLocationLabel.setBounds(10, 10, 165, 25);
        panel.add(addLocationLabel);


        //Location Name
        locationLabel = new JLabel("Location");
        locationLabel.setBounds(10, 40, 165, 25);
        panel.add(locationLabel);

        locationText = new JTextField(20);
        locationText.setBounds(100, 40, 165, 25);
        panel.add(locationText);

        //Location Address
        addressLabel = new JLabel("Address");
        addressLabel.setBounds(10, 70, 80, 25);
        panel.add(addressLabel);

        addressText = new JTextField();
        addressText.setBounds(100, 70, 165, 25);
        panel.add(addressText);

        //Phone Number

        phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(10, 110, 80, 25);
        panel.add(phoneLabel);

        phoneText = new JTextField();
        phoneText.setBounds(100, 110, 165, 25);
        panel.add(phoneText);

        //Category
        categoryLabel = new JLabel("Category");
        categoryLabel.setBounds(10, 140, 80, 25);
        panel.add(categoryLabel);

        categoryText = new JTextField();
        categoryText.setBounds(100, 140, 165, 25);
        panel.add(categoryText);

        addButton = new JButton("Add");
        addButton.setBounds(190, 170, 80, 25);

//        //add button function for add location
        addButton.addActionListener(this);
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (e.getActionCommand().equals("Add")) {
//
//                    String locationName = locationText.getText();
//                    String address = addressText.getText();
//                    String phone = phoneText.getText();
//                    String category = categoryText.getText();
//
//                    addressBook.addLocation(new Location(locationName, address, phone, category));
//
//                }
//            }
//        });
//        public void actionPerformed(ActionEvent e) {
//                if (e.getActionCommand().equals("Add")) {
//
//                    String locationName = locationText.getText();
//                    String address = addressText.getText();
//                    String phone = phoneText.getText();
//                    String category = categoryText.getText();
//
//                    addressBook.addLocation(new Location(locationName, address, phone, category));
//
//                }
//            }
        //addButton.addActionListener(new );
        panel.add(addButton);


        // Search Location Components
        searchLocationLabel = new JLabel("Search Location");
        searchLocationLabel.setBounds(10, 230, 165, 25);
        panel.add(searchLocationLabel);

        //search location
        searchLabel = new JLabel("Location");
        searchLabel.setBounds(10, 260, 80, 25);
        panel.add(searchLabel);
        ;

        searchText = new JTextField();
        searchText.setBounds(100, 260, 165, 25);
        panel.add(searchText);

        searchButton = new JButton("Search");
        searchButton.setBounds(190, 290, 80, 25);

        //search button for search location
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchLocation = searchText.getText();
                for (int i = 0; i < addressBook.getLocations().size(); i++) {
                    if (addressBook.getLocations().get(i).getLocationName().equals(searchLocation)) {
                        //addressBook.searchLocation(searchedLocationName);
                        System.out.println(addressBook.searchLocation(searchLocation));

                    }
                }
            }
        });
        panel.add(searchButton);

        //Remove Location components
        removeLocationLabel = new JLabel("Remove Location");
        removeLocationLabel.setBounds(10, 350, 165, 25);
        panel.add(removeLocationLabel);

        removeLabel = new JLabel("Location");
        removeLabel.setBounds(10,380,80,25);
        panel.add(removeLabel);

        removeText = new JTextField();
        removeText.setBounds(100, 380, 165, 25);
        panel.add(removeText);

        removeButton = new JButton("Remove");
        removeButton.setBounds(190, 410, 80, 25);

        //remove button for remove location
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String removeLocation = removeText.getText();
                for (int i = 0; i < addressBook.getLocations().size(); i++) {
                    if (addressBook.getLocations().get(i).getLocationName().equals(removeLocation)) {
                        addressBook.removeLocation(addressBook.getLocations().get(i));
                    }
                }
            }
        });
        panel.add(removeButton);

        //save and load button
        saveButton = new JButton("Save");
        saveButton.setBounds(50, 480, 80, 25);

        //save button for save addressBook
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel.add(saveButton);

        loadButton = new JButton("Load");
        loadButton.setBounds(150, 480, 80, 25);

        //load button for load addressBook
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                try {
//                    addressBook = jsonReader.read();
//                    System.out.println("Loaded " + addressBook.getLocations() + " from " + JSON_STORE);
//                } catch (IOException e) {
//                    System.out.println("Unable to read from file: " + JSON_STORE);
//                }
//
//
            }

        });
        panel.add(loadButton);

        //Picture
        image = new JLabel();
        image.setBounds(300, 0, 2000, 500);
        //new File("DogGooo Image.png")
        try {
            image.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("DogGooo Image.png"))));

        } catch (IOException e) {
            e.printStackTrace();
        }

        panel.add(image);






        //Create results panel to show load, search location results
        JPanel resultsPanel = new JPanel();
        resultsPanel.setPreferredSize(new Dimension(1000,400));
        panel.add(resultsPanel);


        //frame.setVisible(true);
        return panel;

    }


//    public void actionPerformed(ActionEvent e) {
//        //create actionPerform for add, search, remove, load, save button


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add")) {

            String locationName = locationText.getText();
            String address = addressText.getText();
            String phone = phoneText.getText();
            String category = categoryText.getText();

            addressBook.addLocation(new Location(locationName, address, phone, category));

        }
    }
}
