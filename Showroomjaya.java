package No2;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

    class ShowroomJaya {
        private static final ArrayList<Mobil> car = new ArrayList<>();
        private static final Scanner tata = new Scanner(System.in);
        private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        public static void main(String[] args) throws IOException {
            int choice;
            do {
                System.out.println("1. Tambah Mobil");
                System.out.println("2. Beli Mobil");
                System.out.println("3. Lihat Stok Mobil");
                System.out.println("4. Keluar");

                System.out.print("Masukkan pilihan: ");
                choice = tata.nextInt();
                switch(choice) {
                    case 1:
                        tambahMobil();
                        break;
                    case 2:
                        beliMobil();
                        break;
                    case 3:
                        viewStok();
                        break;
                    case 4:
                        System.out.println("Keluar aplikasi");
                        break;
                }
            }while(choice != 4);
        }

        private static void tambahMobil() throws IOException {
            System.out.println("\nMobil Baru");
            System.out.print("Merk : ");
            String merk = bufferedReader.readLine();
            System.out.print("Harga : ");
            double harga = tata.nextDouble();
            System.out.print("Tahun keluaran : ");
            String tahunKeluaran = bufferedReader.readLine();
            System.out.print("Stok : ");
            int stok = tata.nextInt();
            if (dataMobil(merk, tahunKeluaran) != null) {
                System.out.println("Mobil Sudah tersedia\n");
            }else {
                Mobil p = new Mobil(merk, tahunKeluaran, harga, stok);
                car.add (p);
                System.out.println("Data tersimpan\n");
            }
        }

        private static Mobil dataMobil(String merk, String tahunKeluaran) {
            Mobil pStok = null;
            for (Mobil p : car) {
                if (merk.equals(p.getMerk()) && tahunKeluaran.equals(p.getTahunKeluaran())) {
                    pStok = p;
                }
            }
            return pStok;
        }
        private static void beliMobil() throws IOException {
            System.out.println("\nShowroom Mobil Jaya - Penjualan");
            System.out.print("Merk : ");
            String merk = bufferedReader.readLine();
            System.out.print("Tahun keluaran : ");
            String tahunKeluaran = bufferedReader.readLine();
            System.out.print("Jumlah : " );
            int jumlah = tata.nextInt();
            System.out.println("");
            Mobil p = dataMobil(merk, tahunKeluaran);
            if (p != null){
                if (jumlah == 1){
                    double diskon = 0;
                    double totalHarga = p.getHarga()*jumlah;
                    double totalDiskon = totalHarga*diskon;
                    double totalBayar = totalHarga - totalDiskon;
                    System.out.println("Merk : " + p.getMerk());
                    System.out.println("Harga Satuan : " + String.format("%.1f", p.getHarga()));
                    System.out.println("Tahun Keluaran : " + p.getTahunKeluaran());
                    System.out.println("Jumlah beli : " + jumlah);
                    System.out.println("Total Harga : " + String.format("%.1f", totalHarga));
                    System.out.println("Diskon : " + diskon + " persen" );
                    System.out.println("Total Diskon : " + String.format("%.1f", totalDiskon));
                    System.out.println("Total Bayar  : " + String.format("%.1f", totalBayar) + "\n");
                    int sisaStok = p.getStok()-jumlah;
                    p.setStok(sisaStok);
                } if (jumlah == 2){
                    double diskon = 10;
                    double totalHarga = p.getHarga()*jumlah;
                    double totalDiskon = totalHarga* 0.1;
                    double totalBayar = totalHarga - totalDiskon;
                    System.out.println("Merk : " + p.getMerk());
                    System.out.println("Harga Satuan : " + String.format("%.1f", p.getHarga()));
                    System.out.println("Tahun Keluaran : " + p.getTahunKeluaran());
                    System.out.println("Jumlah beli : " + jumlah);
                    System.out.println("Total Harga : " + String.format("%.1f", totalHarga));
                    System.out.println("Diskon : " + diskon + " persen" );
                    System.out.println("Total Diskon : " + String.format("%.1f", totalDiskon));
                    System.out.println("Total Bayar  : " + String.format("%.1f", totalBayar) + "\n");
                    int sisaStok = p.getStok()-jumlah;
                    p.setStok(sisaStok);
                } if (jumlah >= 3 && jumlah <= p.getStok()){
                    double diskon = 20;
                    double totalHarga = p.getHarga()*jumlah;
                    double totalDiskon = totalHarga * 0.2;
                    double totalBayar = totalHarga - totalDiskon;
                    System.out.println("Merk : " + p.getMerk());
                    System.out.println("Harga Satuan : " + String.format("%.1f", p.getHarga()));
                    System.out.println("Tahun Keluaran : " + p.getTahunKeluaran());
                    System.out.println("Jumlah beli : " + jumlah);
                    System.out.println("Total Harga : " + String.format("%.1f", totalHarga));
                    System.out.println("Diskon : " + diskon + " persen" );
                    System.out.println("Total Diskon : " + String.format("%.1f", totalDiskon));
                    System.out.println("Total Bayar  : " + String.format("%.1f", totalBayar) + "\n");
                    int sisaStok = p.getStok()-jumlah;
                    p.setStok(sisaStok);
                }if (p.getStok() < jumlah){
                    System.out.println("Maaf, jumlah stok tidak mencukupi\n");
                }

            }else{
                System.out.println("Mobil Tidak Ada");
            }


        }
        private static void viewStok(){
            System.out.println("\nInformasi Mobil");
            for (Mobil p:car) {
                p.displayInfo();
                System.out.println("");
            }
        }
}
