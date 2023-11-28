package cz.oauh.test20231113;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvidenceSkladu {
    private List<SkladovaPolozka> skladovePolozky;

    public EvidenceSkladu(List<SkladovaPolozka> skladovePolozky) {
        this.skladovePolozky = skladovePolozky;
    }

    public void pridejPrvek(SkladovaPolozka skladovaPolozka){
        skladovePolozky.add(skladovaPolozka);
    }
    public void odeberPrvek(SkladovaPolozka skladovaPolozka){
        skladovePolozky.remove(skladovaPolozka);
    }
    public List<SkladovaPolozka> ziskejPolozky(){
        return this.skladovePolozky;
    }

    public static void main(String[] args) {
        String soubor = "Text.txt";

        ArrayList<SkladovaPolozka> skladovePolozky = new ArrayList<>();

        try(
                FileReader fileReader = new FileReader(soubor);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                Scanner scanner = new Scanner(bufferedReader);
                )
        {
            while (scanner.hasNextLine()){
                String radek = scanner.nextLine();
                String[] pole = radek.split("#");
                String nazev = pole[0];
                String mnozstviSlovem = pole[1];
                int mnozstvi = Integer.parseInt(mnozstviSlovem);
                String hmotnostSlovem = pole[2];
                double hmotnost = Double.parseDouble(mnozstviSlovem);
                String cenaSlovem = pole[3];
                BigDecimal cena = new BigDecimal(cenaSlovem);
                SkladovaPolozka skladovaPolozka = new SkladovaPolozka(nazev, mnozstvi, hmotnost, cena);
                skladovePolozky.add(skladovaPolozka);

                if (pole.length > 4){
                    throw new EvidenceSkladuException("Zadáno v nesprávném formátu");
                }
            }
        }
        catch (FileNotFoundException e){
            throw new RuntimeException(e.getMessage());
        }
        catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
        catch (EvidenceSkladuException e){
            System.err.println("Chyba: " + e.getMessage());
        }

        SkladovaPolozka skladovaPolozka1 = new SkladovaPolozka("Květináč plastový hnědý", 84, BigDecimal.valueOf(25), true);
        SkladovaPolozka skladovaPolozka2 = new SkladovaPolozka("Poznámkový blok A6+", 10, BigDecimal.valueOf(12.5), true, LocalDate.of(1993, 2, 14));
        SkladovaPolozka skladovaPolozka3 = new SkladovaPolozka("Mrkev", BigDecimal.valueOf(4));

        skladovePolozky.add(skladovaPolozka1);
        skladovePolozky.add(skladovaPolozka2);
        skladovePolozky.add(skladovaPolozka3);

        System.out.println("Názvy všech položek v kontejneru: ");
        for (SkladovaPolozka sK : skladovePolozky){
            System.out.println(sK.getSkladovaPolozka());
        }
        System.out.println(" ");
        System.out.println("Celková cena");

        BigDecimal celkovaCena = BigDecimal.valueOf(0);
        for (SkladovaPolozka sK : skladovePolozky){
            int mnozstvi = sK.getMnozstvi();
            BigDecimal cena = sK.getCena();
            celkovaCena = celkovaCena.add(cena.multiply(BigDecimal.valueOf(mnozstvi)));
        }
        System.out.println(celkovaCena);
        System.out.println(" ");
        System.out.println("Položky kterých je přes 15ks");
        for (SkladovaPolozka sK : skladovePolozky){
            if (sK.getMnozstvi() > 15){
                System.out.println(sK.getSkladovaPolozka());
            }
        }
        System.out.println("");
        System.out.println("Položky s cenou přes 15kč");
        for (SkladovaPolozka sK : skladovePolozky){
            int cislo = sK.getCena().compareTo(BigDecimal.valueOf(15));
            if (cislo == 1){
                System.out.println(sK.getSkladovaPolozka());
            }
        }
    }
}
