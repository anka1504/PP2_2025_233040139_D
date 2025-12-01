package Pertemuan8;

public class Main {
	public static void main(String[] args) {
		//1. instansiasi model
		PersegiPanjangModel model = new PersegiPanjangModel();
		
		//2. instansiasi view
		PersegiPanjangView view = new PersegiPanjangView();
		
		//3. instansiasi controller (hubungkan model & view)
		PersegiPanjangController controller = new PersegiPanjangController(model, view);
		
		//4. tampilkan view 
		view.setVisible(true);
	}

}
