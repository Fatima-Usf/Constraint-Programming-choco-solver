package tp1;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

public class Main {

	public static void main(String[] args) {
		
		/*Model model = new Model("SEND+MORE=MONEY");
		IntVar S = model.intVar("S", 1, 9, false);
		IntVar E = model.intVar("E", 0, 9, false);
		IntVar N = model.intVar("N", 0, 9, false);
		IntVar D = model.intVar("D", 0, 9, false);
		IntVar M = model.intVar("M", 1, 9, false);
		IntVar O = model.intVar("0", 0, 9, false);
		IntVar R = model.intVar("R", 0, 9, false);
		IntVar Y = model.intVar("Y", 0, 9, false);

		model.allDifferent(new IntVar[]{S, E, N, D, M, O, R, Y}).post();

		IntVar[] ALL = new IntVar[]{
		    S, E, N, D,
		    M, O, R, E,
		    M, O, N, E, Y};
		int[] COEFFS = new int[]{
		    1000, 100, 10, 1,
		    1000, 100, 10, 1,
		    -10000, -1000, -100, -10, -1};
		model.scalar(ALL, COEFFS, "=", 0).post();

		Solver solver = model.getSolver();
		solver.showStatistics();
		solver.showSolutions();
		solver.findSolution();
		*/
		

			

		Model model = new Model("modele TP3");
        System.out.println(model.getName());
        IntVar a1 = model.intVar("a1", 1, 9);
        IntVar a2 = model.intVar("a2", 1, 9);
        IntVar a3 = model.intVar("a3", 1, 9);
        IntVar a4 = model.intVar("a4", 1, 9);
        IntVar a5 = model.intVar("a5", 1, 9);
        IntVar a6 = model.intVar("a6", 1, 9);
        IntVar a7 = model.intVar("a7", 1, 9);
        IntVar a8 = model.intVar("a8", 1, 9);
        IntVar a9 = model.intVar("a9", 1, 9);

        int[] coeffs = {1,1,1,-1,-1,-1};

        model.scalar(new IntVar[]{a1,a2,a3,a4,a5,a6}, coeffs, "=", 0).post();
        model.scalar(new IntVar[]{a7,a8,a9,a4,a5,a6}, coeffs, "=", 0).post();
        model.scalar(new IntVar[]{a1,a4,a7,a4,a5,a6}, coeffs, "=", 0).post();
        model.scalar(new IntVar[]{a2,a5,a8,a4,a5,a6}, coeffs, "=", 0).post();
        model.scalar(new IntVar[]{a3,a6,a9,a4,a5,a6}, coeffs, "=", 0).post();
        model.scalar(new IntVar[]{a1,a5,a9,a4,a5,a6}, coeffs, "=", 0).post();
        model.scalar(new IntVar[]{a7,a5,a3,a4,a5,a6}, coeffs, "=", 0).post();

        model.allDifferent(a1, a2, a3, a4, a5, a6, a7, a8, a9).post();
        Solver solver = model.getSolver();
        Solution solution = solver.findSolution();
        int i =1;
        while (solution != null) {
        	
        	System.out.println( i +" --> " + solution.toString()+ "\n" );
            solution = solver.findSolution();
            i++;
        }	
	}}

