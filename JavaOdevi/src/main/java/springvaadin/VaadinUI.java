package springvaadin;

import com.vaadin.data.HasValue;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button.ClickListener;
import springvaadin.WearherService.Service;

import java.util.*;

@SpringUI
@Theme("valo")
public class VaadinUI extends UI {

    @Autowired
    private Service service;
    private WeatherManager weatherManager;

    @Override
    protected void init(VaadinRequest request) {

        List<String> sehirList = new ArrayList<>();
        List<String> addedCityList = new ArrayList<>();
        List<String> ulkeList = new ArrayList<>();


        Label label = new Label("Yusuf \n SATILMIS");
        Label name = new Label("");
        Label sicaklik = new Label("");
        Label nem = new Label("");
        Label basinc = new Label("");
        Label durum = new Label("");
        Label ayrinti = new Label("");
        Label country = new Label("");




        Button addCity = new Button("Ekle");


        ListSelect<String> select = new ListSelect<>("Eklenmiş Şehirler");
        addedCityList.add("sivas");
        select.setItems(addedCityList);
        // select.select("sivas");


        weatherManager = service.getWeather("sivas");
    //    label.setValue(String.valueOf(weatherManager.sys+"--"+ weatherManager.property));


        int konum1=String.valueOf(weatherManager.weather).indexOf("main=");
        int konum2=String.valueOf(weatherManager.weather).indexOf(", ");
        String Durum=String.valueOf(weatherManager.weather).substring(konum1+5,konum2);

        int konum3=String.valueOf(weatherManager.weather).indexOf("description=");
        int konum4=String.valueOf(weatherManager.weather).indexOf("]]");
        String Durum2=String.valueOf(weatherManager.weather).substring(konum3+12,konum4);

        name.setValue("Sehir="+String.valueOf(weatherManager.name) );
        sicaklik.setValue("Sıcaklık="+String.valueOf((int) (Math.floor(weatherManager.main.temp) - 273)) + "°C");
        nem.setValue("Nem oranı=%"+String.valueOf(weatherManager.main.humidity) );
        basinc.setValue("Basınç="+String.valueOf(weatherManager.main.pressure));
        durum.setValue("Durum="+Durum);
        ayrinti.setValue("Ayrıntı="+Durum2);
        country.setValue("Ülke="+String.valueOf(weatherManager.sys.country));

        for (City tmp : City.elements) {
            if (!ulkeList.contains(tmp.country))
                ulkeList.add(tmp.country);
        }


        ComboBox<String> selectUlke = new ComboBox<>("Ülke Seçiniz");
        selectUlke.setItems(ulkeList);

        ComboBox<String> selectSehir = new ComboBox<>("Şehir Seçiniz");
        selectSehir.setItems(sehirList);


        selectUlke.addValueChangeListener(new HasValue.ValueChangeListener<String>() {
            @Override
            public void valueChange(HasValue.ValueChangeEvent<String> valueChangeEvent) {


                sehirList.clear();


                for (City tmp : City.elements) {


                    if (selectUlke.getValue().equals(tmp.country)) {

                        if (!sehirList.contains(tmp.name))
                            sehirList.add(tmp.name);


                    }


                }


                selectSehir.setItems(sehirList);
            }
        });


        addCity.addClickListener(new ClickListener() {
            private static final long serialVersionUID = -8424487726640573041L;

            @Override
            public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {

                String temp = select.getValue().toString();
                temp = temp.substring(1, temp.length() - 1);

                select.clear();
                select.setItems();


                if (!selectSehir.isEmpty())

                    if (!addedCityList.contains(selectSehir.getValue())) {
                        addedCityList.add(selectSehir.getValue());


                    }

                select.setItems(addedCityList);



            }
        });


        select.addValueChangeListener(new HasValue.ValueChangeListener<Set<String>>() {
            @Override
            public void valueChange(HasValue.ValueChangeEvent<Set<String>> valueChangeEvent) {

                String temp = select.getValue().toString();
                temp = temp.substring(1, temp.length() - 1);

                weatherManager = service.getWeather(temp);

                int konum1=String.valueOf(weatherManager.weather).indexOf("main=");
                int konum2=String.valueOf(weatherManager.weather).indexOf(", ");
                String Durum=String.valueOf(weatherManager.weather).substring(konum1+5,konum2);

                int konum3=String.valueOf(weatherManager.weather).indexOf("description=");
                int konum4=String.valueOf(weatherManager.weather).indexOf("]]");
                String Durum2=String.valueOf(weatherManager.weather).substring(konum3+12,konum4);

                name.setValue("Sehir="+String.valueOf(weatherManager.name) );
                sicaklik.setValue("Sıcaklık="+String.valueOf((int) (Math.floor(weatherManager.main.temp) - 273)) + "°C");
                nem.setValue("Nem oranı=%"+String.valueOf(weatherManager.main.humidity) );
                basinc.setValue("Basınç="+String.valueOf(weatherManager.main.pressure));
                durum.setValue("Durum="+Durum);
                ayrinti.setValue("Ayrıntı="+Durum2);
                country.setValue("Ülke="+String.valueOf(weatherManager.sys.country));

            }
        });
        //	grid.addColumn("yusuf").setCaption("ggggg");


        HorizontalLayout rightTop = new HorizontalLayout(selectUlke, selectSehir, addCity);
        VerticalLayout rightBottom = new VerticalLayout(country,name,sicaklik,nem,basinc,durum,ayrinti);
        VerticalLayout leftMenu = new VerticalLayout(label, select);
        VerticalLayout rightMenu = new VerticalLayout(rightTop, rightBottom);
        HorizontalLayout main = new HorizontalLayout(leftMenu, rightMenu);

        main.setMargin(true);
        main.setSpacing(true);
        setContent(main);


    }

}
