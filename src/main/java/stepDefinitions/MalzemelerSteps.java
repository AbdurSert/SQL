package stepDefinitions;

import io.cucumber.datatable.internal.difflib.Delta;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Do;
import org.junit.Assert;
import utilities.TestBase;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class MalzemelerSteps extends TestBase {


    @Given("Kullanici database'e erisim saglar")
    public void kullaniciDatabaseEErisimSaglar() throws SQLException {

        dbconnection();

    }

    @When("Kullanici mlzemeler tablosuna gider")
    public void kullaniciMlzemelerTablosunaGider() throws SQLException {

        resultSet = statement.executeQuery("SELECT * FROM malzemeler");

    }

    @Then("Kullanici tablodaki toplam urun sayisni dogrular")
    public void kullaniciTablodakiToplamUrunSayisniDogrular() throws SQLException {

        int count = 1;
        resultSet.first();

        while(resultSet.next()){

            count++;
        }

        System.out.println(count);

        Assert.assertEquals(count, 10);
    }

    @Then("KUllanici tablodan fiyati en yuksek urunu bulur ve dogrular")
    public void kullaniciTablodanFiyatiEnYuksekUrunuBulurVeDogrular() throws SQLException {

      resultSet = statement.executeQuery("SELECT MAX(price) FROM malzemeler;");


      resultSet.absolute(1);
      String highest = resultSet.getString("max");

        System.out.println(highest);

        Assert.assertTrue(highest.equals("120.75"));


    }

    @Then("Kullanici urulerden birinin ismini degistirip dogrular")
    public void kullaniciUrulerdenBirininIsminiDegistiripDogrular() throws SQLException {

        resultSet  = statement.executeQuery("Update malzemeler Set name = 'Vana' Where name = 'Vida' ");

        resultSet.absolute(8);
        String abc = resultSet.getString("name");

        System.out.println(abc);

    }


    @Then("Kullanici urunlerin toplam fiyatinin ortalamsini bulup dogrular")
    public void kullaniciUrunlerinToplamFiyatininOrtalamsiniBulupDogrular() throws SQLException {

        resultSet= statement.executeQuery("SELECT AVG(price) FROM malzemeler;");


        resultSet.absolute(1);
        String avgPrice= resultSet.getString("avg").substring(0,6);

        System.out.println(avgPrice);

        Assert.assertTrue(avgPrice.equals("24.384"));

    }

    @And("Kullanici urunlerin basliklarini yazdirir")
    public void kullaniciUrunlerinBasliklariniYazdirir() throws SQLException {




    }

    @And("Kullanici urun isimlerinin harflerini hepsi buyuk olacak sekilde yazdirir")
    public void kullaniciUrunIsimlerininHarfleriniHepsiBuyukOlacakSekildeYazdirir() throws SQLException {

        List<String> urunList = new ArrayList<String>();

        resultSet.first();

        while (resultSet.next()){



            String urunler= resultSet.getString("name").toUpperCase();

            urunList.add(urunler);
        }

        System.out.println(urunList);

    }

    @And("Kullanici urun isimlerinin harflerini hepsi kucuk olacak sekilde yazdirir")
    public void kullaniciUrunIsimlerininHarfleriniHepsiKucukOlacakSekildeYazdirir() throws SQLException {

        List<String> urunList2 = new ArrayList<String>();

        resultSet.first();

        while (resultSet.next()){



            String urunler= resultSet.getString("name").toLowerCase();

            urunList2.add(urunler);
        }

        System.out.println(urunList2);

    }

    @And("Kullanici urun isimlerinin ilk harfleri buyuk olacak sekilde yazdirir")
    public void kullaniciUrunIsimlerininIlkHarfleriBuyukOlacakSekildeYazdirir() throws SQLException {

        List<String> urunList3 = new ArrayList<String>();

        resultSet.first();

        while (resultSet.next()){



            String urunler= resultSet.getString("name");

            urunList3.add(urunler.toUpperCase().substring(0,1) +urunler.substring(1).toLowerCase());
        }

        System.out.println(urunList3);



    }

    @And("Kullanici fiyati {int} dan kucuk olanlari isme ve fiyata gore azalacak sekilde siralar, yazdirir")
    public void kullaniciFiyatiDanKucukOlanlariIsmeVeFiyataGoreAzalacakSekildeSiralarYazdirir(int arg0) throws SQLException {

        List<Double> priceListDesc = new ArrayList<Double>();
        List<String> nameLIstDesc = new ArrayList<String>();

        resultSet = statement.executeQuery("Select price from malzemeler where price < 10 order by price desc;");

        resultSet.first();
        while(resultSet.next()){

            double pricesDesc = resultSet.getDouble(1);
            priceListDesc.add(pricesDesc);

        }

        System.out.println(priceListDesc);

        resultSet = statement.executeQuery("Select name from malzemeler where price < 10 order by price desc;");

        resultSet.first();
        while(resultSet.next()){

            String nameDesc = resultSet.getString(1);
            nameLIstDesc.add(nameDesc);


        }

        System.out.println(nameLIstDesc);


    }


    @Then("Kullanici tabloyu kapatir")
    public void kullaniciTabloyuKapatir() {
    }


}
