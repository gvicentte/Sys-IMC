package Ex1.Principal;

import Ex1.Model.Funcionario;
import Ex1.Model.ProcessadorFuncionarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ProcessadorFuncionarios processador = new ProcessadorFuncionarios();
        processador.gerarRelatorio();
    }
}