package AlphaTester;

import java.util.ArrayList;

public class GrupoDeTeste {

	private String mNameSpace;

	private int mAprovados;
	private int mReprovados;
	private ArrayList<String> mAssinaturas;

	public GrupoDeTeste(String eNameSpace) {
		
		mNameSpace = eNameSpace;
		mAprovados = 0;
		mReprovados = 0;

		mAssinaturas = new ArrayList<String>();

	}

	public void setNameSpace(String eNameSpace) {
		mNameSpace = eNameSpace;
	}

	public String getNameSpace() {
		return mNameSpace;
	}

	public int getTestes() {
		return (mAprovados + mReprovados);
	}

	public int getAprovados() {
		return mAprovados;
	}

	public void setAprovados(int eAprovados) {
		mAprovados = eAprovados;
	}

	public int getReprovados() {
		return mReprovados;
	}

	public void setReprovados(int eReprovados) {
		mReprovados = eReprovados;
	}

	public ArrayList<String> getAssinaturas() {
		return mAssinaturas;
	}

	public void Aprovar(String eCommit) {

		mAprovados += 1;
		mAssinaturas.add(eCommit);

	}

	public void Reprovar(String eCommit) {

		mReprovados += 1;
		mAssinaturas.add(eCommit);

	}

}
