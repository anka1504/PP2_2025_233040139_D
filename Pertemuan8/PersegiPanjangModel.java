package Pertemuan8;

public class PersegiPanjangModel {
	private double panjang;
	private double lebar;
	private double luas;
	
	// menghitung luas (Logika Bisnis)
	public void hitungLuas () {
		this.luas = this.panjang * this.lebar;
	}
	
	// Getters dan Setters
	public void setPanjang (double panjang) {
		this.panjang = panjang;
	}
	
	public void setLebar (double lebar) {
		this.lebar = lebar;
	}
	
	public double getLuas() {
		return luas;
	}

}
