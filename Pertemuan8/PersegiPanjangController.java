package Pertemuan8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class PersegiPanjangController {
	// model dan view sebagai atribut kelas
	private PersegiPanjangModel model;
	private PersegiPanjangView view;
	
	public PersegiPanjangController(PersegiPanjangModel model, PersegiPanjangView view) {
		this.model = model;
		this.view = view;
		
		// menghubungkan tombol di view dengan logic di controller
		this.view.addHitungListener(new HitungListener());
	}
	
	// inner class untuk menangani event klik tombol
	class HitungListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				// 1. ambil data dari view 
				double p = view.getPanjang();
				double l = view.getLebar();
				
				//2. kirim data ke model
				model.setPanjang(p);
				model.setLebar(l);
				
				//3. jalankan logika bisnis di model
				model.hitungLuas();
				
				//4. ambil hasil dari model dan tampilkan kembali di view 
				double hasil = model.getLuas();
				view.setHasil(hasil);
				
			} catch (NumberFormatException ex) {
				// handle jika user memasukkan huruf
				view.tampilkanPesanError("Masukkan angka yang valid!");
				
			}
		}
	}

}
