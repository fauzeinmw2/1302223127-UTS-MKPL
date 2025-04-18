package lib;

public class TaxFunction {

	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	
	
	public static int calculateTax(TaxCalculationData data) {
		int tax = 0;
	
		if (data.numberOfMonthWorking > 12) {
			System.err.println("More than 12 month working per year");
		}
	
		int children = Math.min(data.numberOfChildren, 3);
		int nonTaxable = 54000000 + (data.isMarried ? 4500000 : 0) + (children * 1500000);
	
		double annualNetIncome = ((data.monthlySalary + data.otherMonthlyIncome) * data.numberOfMonthWorking) - data.deductible;
		tax = (int) Math.round(0.05 * (annualNetIncome - nonTaxable));
	
		return Math.max(tax, 0);
	}	
}
