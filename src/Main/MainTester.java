package Main;

import AlphaTester.AlphaTester;

public class MainTester  extends AlphaTester {

	public static void main(String[] str) {
		
		MainTester MT = new MainTester("MainTester_V1");
		
		
	}
	
	public MainTester(String eNome) {
		
		System.out.println("  ");
		System.out.println("------------------------- TESTES -------------------------");
		
		
		TEST(eNome, "Global");
		ASSERT_NE("O2", "O3");
		ASSERT_EQ("O3", "O3");
		ASSERT_TRUE(true);

		
		
		TEST(eNome, "Texto");
		ASSERT_EQ("Agua", "Agua");


		TEST(eNome, "Numeros");
		ASSERT_EQ(8, 8);
		ASSERT_NE(8, 3);
		ASSERT_EQ(3, 3);
		ASSERT_BIGGER(8, 3);
		ASSERT_SMALLER(3, 8);
		ASSERT_NE(8, 3);
		ASSERT_NE(3, 8);
		ASSERT_EQ(8, 8);
		ASSERT_EQ(3, 3);


		System.out.println("  ");
		System.out.println("  ");

		ANALISE();
		
		System.out.println("  ");
		System.out.println("------------------------- RESUMO -------------------------");
		System.out.println("  ");

		RESUME();
		
		System.out.println("  ");
		System.out.println("------------------------- QUANTITATIVO -------------------------");
		System.out.println("  ");
		
		//TESTES();

		ESTATISTICAS();
	}
}
