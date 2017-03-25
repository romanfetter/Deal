package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.FloatStringConverter;

import javax.swing.table.DefaultTableModel;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringJoiner;

public class Controller implements Initializable {
    public TableView mainTable;
    public TextField textPurchAmount;
    public TextField textDrAmount;
    public TextField textSellAmount;
    public TextField textProfit;
    public TextField textProfitability;
    private final ObservableList<Product> products = FXCollections.observableArrayList();// Список пролуктов

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mainTable.setEditable(true);
        TableColumn titleColumn = new TableColumn("Наименование");
        TableColumn unitColumn = new TableColumn("Ед. изм.");
        TableColumn volumeColumn = new TableColumn("Количество");
        TableColumn purchPriceColumn = new TableColumn("Цена покупки");
        TableColumn sellPriceColumn = new TableColumn("Цена продажи");
        TableColumn drPriceColumn = new TableColumn("ДР");
        TableColumn purchAmountColumn = new TableColumn("Сумма покупки");
        TableColumn sellAmountColumn = new TableColumn("Сумма продажи");
        TableColumn drAmountColumn = new TableColumn("Сумма ДР");


        products.add(new Product("Мука", "т.", 10f, 10f, 15f, 5f, 0, 0, 0));
        products.add(new Product("Вода", "л.", 1000f, 10f, 20f, 6f, 0, 0, 0));
        products.add(new Product("Зерно", "т.", 5f, 10f, 1f, 30f, 7f, 0, 0));

        titleColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("title"));
        unitColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("unit"));
        volumeColumn.setCellValueFactory(new PropertyValueFactory<Product, Float>("volume"));
        purchPriceColumn.setCellValueFactory(new PropertyValueFactory<Product, Float>("purchPrice"));
        sellPriceColumn.setCellValueFactory(new PropertyValueFactory<Product, Float>("sellPrice"));
        drPriceColumn.setCellValueFactory(new PropertyValueFactory<Product, Float>("drPrice"));
        purchAmountColumn.setCellValueFactory(new PropertyValueFactory<Product, Float>("purchAmount"));
        sellAmountColumn.setCellValueFactory(new PropertyValueFactory<Product, Float>("saleAmount"));
        drAmountColumn.setCellValueFactory(new PropertyValueFactory<Product, Float>("drAmount"));

        titleColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        //unitColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        unitColumn.setCellFactory(ComboBoxTableCell.forTableColumn("тн.", "кг."));
        volumeColumn.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        purchPriceColumn.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        sellPriceColumn.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        drPriceColumn.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));


        titleColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Product, String>>() {
                                        @Override
                                        public void handle(TableColumn.CellEditEvent<Product, String> t) {
                                            ((Product) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTitle(t.getNewValue());
                                        }
                                    }
        );

        volumeColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Product, Float>>() {
                                         @Override
                                         public void handle(TableColumn.CellEditEvent<Product, Float> t) {
                                             ((Product) t.getTableView().getItems().get(t.getTablePosition().getRow())).setVolume(t.getNewValue());
                                             calulate();
                                         }
                                     }
        );

        purchPriceColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Product, Float>>() {
                                             @Override
                                             public void handle(TableColumn.CellEditEvent<Product, Float> t) {
                                                 ((Product) t.getTableView().getItems().get(t.getTablePosition().getRow())).setpurchPrice(t.getNewValue());
                                                 calulate();
                                             }
                                         }
        );
        sellPriceColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Product, Float>>() {
                                            @Override
                                            public void handle(TableColumn.CellEditEvent<Product, Float> t) {
                                                ((Product) t.getTableView().getItems().get(t.getTablePosition().getRow())).setSellPrice(t.getNewValue());
                                                calulate();
                                            }
                                        }
        );
        drPriceColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Product, Float>>() {
                                          @Override
                                          public void handle(TableColumn.CellEditEvent<Product, Float> t) {
                                              ((Product) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDrPrice(t.getNewValue());
                                              calulate();
                                          }
                                      }
        );


        mainTable.setItems(products);
        mainTable.getColumns().addAll(titleColumn, unitColumn, volumeColumn, purchPriceColumn, sellPriceColumn, drPriceColumn, purchAmountColumn, sellAmountColumn, drAmountColumn);


    }


    public void onBtnClick(ActionEvent actionEvent) {
        calulate();
    }

    public void onAddBtnClick(ActionEvent actionEvent) {
        products.add(new Product("", "", 0f, 0f, 0, 0, 0, 0, 0));
    }

    public void calulate() {
        for (int i = 0; i < products.size(); i++) {
            Product a = products.get(i);
            a.setPurchAmount(a.getpurchPrice() * a.getVolume());
            a.setSellAmount(a.getSellPrice() * a.getVolume());
            a.setDrAmount(a.getDrPrice() * a.getVolume());

        }
        float allPurchAmount = 0;
        for (int i = 0; i < products.size(); i++) {
            Product a = products.get(i);
            allPurchAmount += a.getPurchAmount();
        }
        textPurchAmount.setText(String.valueOf(allPurchAmount));

        float allSellAmount = 0;
        for (int i = 0; i <products.size() ; i++) {
            Product a = products.get(i);
            allSellAmount += a.getSellAmount();
        }
        textSellAmount.setText(String.valueOf(allSellAmount));

        float allDrAmount = 0;
        for (int i = 0; i < products.size(); i++) {
            Product a = products.get(i);
            allDrAmount += a.getDrAmount();
        }
        textDrAmount.setText(String.valueOf(allDrAmount));

        float Profit = 0;
        Profit = allSellAmount - allPurchAmount - allDrAmount;
        textProfit.setText(String.valueOf(Profit));

        float Profitability = 0;
        Profitability = ((Profit * 100) / allPurchAmount);
        textProfitability.setText(String.valueOf(Profitability));



    }


}


