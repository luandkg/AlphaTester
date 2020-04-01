package AlphaTester;

import java.util.ArrayList;

public class AlphaTester {

	public final String DESENVOLVEDOR = "LUAN FREITAS";

	public final String DDC = "2020 03 24";
	public final String DDI = "2020 03 23";
	public final String DDM = "2020 03 24";

	private String mGrupo;
	private String mFuncao;
	private ArrayList<GrupoDeTeste> mGrupos;
	private ArrayList<String> mTestes;

	private long mInicio;

	public AlphaTester() {
		mGrupo = "";
		mFuncao = "";

		mGrupos = new ArrayList<GrupoDeTeste>();
		mTestes = new ArrayList<String>();
		mInicio = System.nanoTime();

	}

	public void TEST(String eGrupo, String eFuncao) {

		mGrupo = eGrupo;
		mFuncao = eFuncao;
		mInicio = System.nanoTime();

		

	}

	private String getAssinatura() {
		String ret = "";

		if (mGrupo.length() > 0) {
			ret = mGrupo;
			if (mFuncao.length() > 0) {
				ret += "." + mFuncao;
			}
		} else {

			if (mFuncao.length() > 0) {
				ret += "." + mFuncao;
			}

		}

		return ret;
	}

	public void AssinarGrupo(String eNameSpace, boolean eResultado) {

		GrupoDeTeste GDT = null;
		boolean enc = false;

		for (GrupoDeTeste eGDT : mGrupos) {

			if (eGDT.getNameSpace().contentEquals(eNameSpace)) {
				enc = true;
				GDT = eGDT;
				break;
			}

		}

		if (enc == false) {

			GDT = new GrupoDeTeste(eNameSpace);
			mGrupos.add(GDT);

		}

		if (eResultado) {
			GDT.Aprovar("[ PASSED ] : " + eNameSpace);
			mTestes.add("[ PASSED ] : " + eNameSpace);

		} else {
			GDT.Reprovar("[ FAILED ] : " + eNameSpace);
			mTestes.add("[ FAILED ] : " + eNameSpace);

		}

	}

	public void ANALISE() {

		for (GrupoDeTeste eGDT : mGrupos) {

			System.out.println(eGDT.getNameSpace() + " :: " + eGDT.getTestes() + " -> [" + eGDT.getAprovados() + " - "
					+ eGDT.getReprovados() + "] ");

			for (String eAssinatura : eGDT.getAssinaturas()) {

				System.out.println("   - " + eAssinatura);

			}

		}

	}

	public void RESUME() {

		for (GrupoDeTeste eGDT : mGrupos) {

			System.out.println(eGDT.getNameSpace() + " :: " + eGDT.getTestes() + " -> [" + eGDT.getAprovados() + " - "
					+ eGDT.getReprovados() + "] ");

		}

	}

	public void TESTES() {

		int t = 0;

		for (String eAssinatura : mTestes) {

			System.out.println("   - " + t + " : " + eAssinatura);

			t += 1;

		}

	}

	public long getDelta() {
		return (System.nanoTime() - mInicio);
	}

	public void ESTATISTICAS() {

		int Total = 0;
		int Aprovados = 0;
		int Reprovados = 0;

		for (GrupoDeTeste eGDT : mGrupos) {

			Total += eGDT.getTestes();
			Aprovados += eGDT.getAprovados();
			Reprovados += eGDT.getReprovados();

		}

		float taxa = (float) Total / 100.0f;

		float ta = (float) Aprovados / taxa;
		float re = (float) Reprovados / taxa;

		System.out.println("   -  Testes\t\t: " + Total + "  - " + "100.00" + " %");
		System.out.println("   -  Aprovados\t\t: " + Aprovados + "  - " + String.format("%.2f", ta).toString() + " %");
		System.out.println("   -  Reprovados\t: " + Reprovados + "  - " + String.format("%.2f", re).toString() + " %");

	}

	// TESTE DE IGUALDADE

	public void ASSERT_EQ(String Argumento_1, String Argumento_2) {

		if (Argumento_1.contentEquals(Argumento_2)) {
			AssinarGrupo(getAssinatura(), true);

		} else {
			AssinarGrupo(getAssinatura(), false);

		}

	}

	public void ASSERT_EQ(int Argumento_1, int Argumento_2) {

		if (Argumento_1 == (Argumento_2)) {
			AssinarGrupo(getAssinatura(), true);

		} else {
			AssinarGrupo(getAssinatura(), false);

		}

	}

	public void ASSERT_EQ(short Argumento_1, short Argumento_2) {

		if (Argumento_1 == (Argumento_2)) {
			AssinarGrupo(getAssinatura(), true);

		} else {
			AssinarGrupo(getAssinatura(), false);

		}

	}

	public void ASSERT_EQ(float Argumento_1, float Argumento_2) {

		if (Argumento_1 == (Argumento_2)) {
			AssinarGrupo(getAssinatura(), true);

		} else {
			AssinarGrupo(getAssinatura(), false);

		}

	}

	public void ASSERT_EQ(double Argumento_1, double Argumento_2) {

		if (Argumento_1 == (Argumento_2)) {
			AssinarGrupo(getAssinatura(), true);

		} else {
			AssinarGrupo(getAssinatura(), false);

		}

	}

	public void ASSERT_EQ(boolean Argumento_1, boolean Argumento_2) {

		if (Argumento_1 == (Argumento_2)) {
			AssinarGrupo(getAssinatura(), true);

		} else {
			AssinarGrupo(getAssinatura(), false);

		}

	}

	// TESTES LOGICOS

	public void ASSERT_TRUE(boolean Argumento) {

		if (Argumento) {
			AssinarGrupo(getAssinatura(), true);

		} else {
			AssinarGrupo(getAssinatura(), false);

		}

	}

	public void ASSERT_FALSE(boolean Argumento) {

		if (Argumento) {
			AssinarGrupo(getAssinatura(), false);

		} else {
			AssinarGrupo(getAssinatura(), true);

		}

	}

	public void ASSERT_NULL(Object Argumento) {

		if (Argumento == null) {
			AssinarGrupo(getAssinatura(), false);

		} else {
			AssinarGrupo(getAssinatura(), true);

		}

	}

	// TESTES DE DESIGULADE

	public void ASSERT_NE(String Argumento_1, String Argumento_2) {

		if (Argumento_1.contentEquals(Argumento_2)) {
			AssinarGrupo(getAssinatura(), false);

		} else {
			AssinarGrupo(getAssinatura(), true);

		}

	}

	public void ASSERT_NE(int Argumento_1, int Argumento_2) {

		if (Argumento_1 == (Argumento_2)) {
			AssinarGrupo(getAssinatura(), false);

		} else {
			AssinarGrupo(getAssinatura(), true);

		}

	}

	public void ASSERT_NE(short Argumento_1, short Argumento_2) {

		if (Argumento_1 == (Argumento_2)) {
			AssinarGrupo(getAssinatura(), false);

		} else {
			AssinarGrupo(getAssinatura(), true);

		}

	}

	public void ASSERT_NE(float Argumento_1, float Argumento_2) {

		if (Argumento_1 == (Argumento_2)) {
			AssinarGrupo(getAssinatura(), false);

		} else {
			AssinarGrupo(getAssinatura(), true);

		}

	}

	public void ASSERT_NE(double Argumento_1, double Argumento_2) {

		if (Argumento_1 == (Argumento_2)) {
			AssinarGrupo(getAssinatura(), false);

		} else {
			AssinarGrupo(getAssinatura(), true);

		}

	}

	public void ASSERT_NE(boolean Argumento_1, boolean Argumento_2) {

		if (Argumento_1 == (Argumento_2)) {
			AssinarGrupo(getAssinatura(), false);

		} else {
			AssinarGrupo(getAssinatura(), true);

		}

	}

	// TESTES DE GRANDEZA - MAIOR

	public void ASSERT_BIGGER(int Argumento_1, int Argumento_2) {

		if (Argumento_1 > (Argumento_2)) {
			AssinarGrupo(getAssinatura(), true);

		} else {
			AssinarGrupo(getAssinatura(), false);

		}

	}

	public void ASSERT_BIGGER(short Argumento_1, short Argumento_2) {

		if (Argumento_1 > (Argumento_2)) {
			AssinarGrupo(getAssinatura(), true);

		} else {
			AssinarGrupo(getAssinatura(), false);

		}

	}

	public void ASSERT_BIGGER(float Argumento_1, float Argumento_2) {

		if (Argumento_1 > (Argumento_2)) {
			AssinarGrupo(getAssinatura(), true);

		} else {
			AssinarGrupo(getAssinatura(), false);

		}

	}

	public void ASSERT_BIGGER(double Argumento_1, double Argumento_2) {

		if (Argumento_1 > (Argumento_2)) {
			AssinarGrupo(getAssinatura(), true);

		} else {
			AssinarGrupo(getAssinatura(), false);

		}

	}

	// TESTES DE GRANDEZA - MENOR

	public void ASSERT_SMALLER(int Argumento_1, int Argumento_2) {

		if (Argumento_1 < (Argumento_2)) {
			AssinarGrupo(getAssinatura(), true);

		} else {
			AssinarGrupo(getAssinatura(), false);

		}

	}

	public void ASSERT_SMALLER(short Argumento_1, short Argumento_2) {

		if (Argumento_1 < (Argumento_2)) {
			AssinarGrupo(getAssinatura(), true);

		} else {
			AssinarGrupo(getAssinatura(), false);

		}

	}

	public void ASSERT_SMALLER(float Argumento_1, float Argumento_2) {

		if (Argumento_1 < (Argumento_2)) {
			AssinarGrupo(getAssinatura(), true);

		} else {
			AssinarGrupo(getAssinatura(), false);

		}

	}

	public void ASSERT_SMALLER(double Argumento_1, double Argumento_2) {

		if (Argumento_1 < (Argumento_2)) {
			AssinarGrupo(getAssinatura(), true);

		} else {
			AssinarGrupo(getAssinatura(), false);

		}

	}

}
