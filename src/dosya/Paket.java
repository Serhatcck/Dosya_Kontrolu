package dosya;

public class Paket extends Dosya {
	public Paket(String seriNo, String tur, String boyut, String desi) {
		this.SeriNo = seriNo;
		this.Desi = desi;
		this.Tur = tur;
		this.Icerik= boyut;
	}
}
