import java.util.List;

 class Calculadora {
    public static void main(String[] args) {
        // Crie uma lista de números para as operações
        List<Double> numeros = List.of(10.0, 5.0, 2.0);

        // Realize as operações desejadas
        Operacao soma = new Soma();
        Operacao subtracao = new Subtracao();
        Operacao multiplicacao = new Multiplicacao();
        Operacao divisao = new Divisao();

        System.out.println("Soma: " + soma.calcular(numeros));
        System.out.println("Subtração: " + subtracao.calcular(numeros));
        System.out.println("Multiplicação: " + multiplicacao.calcular(numeros));
        System.out.println("Divisão: " + divisao.calcular(numeros));
    }
}




// Interface para operações matemáticas
interface Operacao {
    double calcular(List<Double> numeros);
}

// Implementações das operações
class Soma implements Operacao {
    @Override
    public double calcular(List<Double> numeros) {
        double resultado = 0;
        for (Double numero : numeros) {
            resultado += numero;
        }
        return resultado;
    }
}

class Subtracao implements Operacao {
    @Override
    public double calcular(List<Double> numeros) {
        if (numeros.isEmpty()) {
            throw new IllegalArgumentException("A lista de números não pode estar vazia.");
        }

        double resultado = numeros.get(0);
        for (int i = 1; i < numeros.size(); i++) {
            resultado -= numeros.get(i);
        }
        return resultado;
    }
}

class Multiplicacao implements Operacao {
    @Override
    public double calcular(List<Double> numeros) {
        double resultado = 1;
        for (Double numero : numeros) {
            resultado *= numero;
        }
        return resultado;
    }
}

class Divisao implements Operacao {
    @Override
    public double calcular(List<Double> numeros) {
        if (numeros.isEmpty()) {
            throw new IllegalArgumentException("A lista de números não pode estar vazia.");
        }

        double resultado = numeros.get(0);
        for (int i = 1; i < numeros.size(); i++) {
            if (numeros.get(i) == 0) {
                throw new ArithmeticException("Divisão por zero não é permitida.");
            }
            resultado /= numeros.get(i);
        }
        return resultado;
    }
}



