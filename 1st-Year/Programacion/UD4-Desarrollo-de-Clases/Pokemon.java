package pokemon;

import java.util.*;

//Creación de la Superclase Pokemon
public class Pokemon {
    private String nombre;
    private int nivel;
    private String tipo;
    private int salud;

    // Constructor con parámetros de Pokemon
    public Pokemon(String nombre, int nivel, String tipo, int salud) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.tipo = tipo;
        this.salud = salud;
    }

    public Pokemon() {
        this("Desconocido", 1, "Desconocido", 100);
    }

    // Métodos getter y setter
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getNivel() { return nivel; }
    public void setNivel(int nivel) { this.nivel = nivel; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public int getSalud() { return salud; }
    public void setSalud(int salud) { this.salud = salud; }
    
    //Método toString
    @Override
    public String toString() {
        return nombre; // Devuelve solo el nombre del Pokémon cuando se imprima
    }

    // Método para mostrar la información del Pokémon
    public void mostrarInfo() {
        System.out.println(nombre + ", Nivel: " + nivel + ", Tipo: " + tipo + ", Salud: " + salud);
    }

    // Clase hija PokemonFuego
    static class PokemonFuego extends Pokemon {
        private int ascuasEmber;
        private int enviteIgneo;

        public PokemonFuego(String nombre, int nivel, int ascuasEmber, int enviteIgneo) {
            super(nombre, nivel, "Fuego", 100);
            this.ascuasEmber = ascuasEmber;
            this.enviteIgneo = enviteIgneo;
        }

        public int lanzarEnviteIgneo() {
            int dano = (int) (Math.random() * enviteIgneo) + 10;
            System.out.println(getNombre() + " usa Envite Ígneo causando " + dano + " de daño!");
            return dano;
        }

        @Override
        public void mostrarInfo() {
            super.mostrarInfo();
            System.out.println("Ascuas Ember: " + ascuasEmber + ", Envite Ígneo: " + enviteIgneo);
        }
    }

    // Clase hija PokemonRayo
    static class PokemonRayo extends Pokemon {
        private int electricidadEstatica;
        private int chispa;

        public PokemonRayo(String nombre, int nivel, int electricidadEstatica, int chispa) {
            super(nombre, nivel, "Rayo", 100);
            this.electricidadEstatica = electricidadEstatica;
            this.chispa = chispa;
        }

        public int lanzarChispa() {
            int dano = (int) (Math.random() * chispa) + 10;
            System.out.println(getNombre() + " usa Chispa causando " + dano + " de daño!");
            return dano;
        }

        @Override
        public void mostrarInfo() {
            super.mostrarInfo();
            System.out.println("Electricidad Estática: " + electricidadEstatica + ", Chispa: " + chispa);
        }
    }

    // Clase hija PokemonAgua
    static class PokemonAgua extends Pokemon {
        private int torrente;
        private int acuaJet;

        public PokemonAgua(String nombre, int nivel, int torrente, int acuaJet) {
            super(nombre, nivel, "Agua", 100);
            this.torrente = torrente;
            this.acuaJet = acuaJet;
        }

        public int lanzarAcuaJet() {
            int dano = (int) (Math.random() * acuaJet) + 10;
            System.out.println(getNombre() + " usa Acua Jet causando " + dano + " de daño!");
            return dano;
        }

        @Override
        public void mostrarInfo() {
            super.mostrarInfo();
            System.out.println("Torrente: " + torrente + ", Acua Jet: " + acuaJet);
        }
    }

    //Creación de los Pokemon y Entrenadores
    public static void main(String[] args) {
        PokemonFuego charmander = new PokemonFuego("Charmander", 5, 50, 70);
        PokemonRayo pikachu = new PokemonRayo("Pikachu", 6, 60, 80);
        PokemonAgua squirtle = new PokemonAgua("Squirtle", 5, 55, 75);

        Entrenador ash = new Entrenador("Ash", 100, pikachu, "Pueblo Paleta", 20);
        Entrenador misty = new Entrenador("Misty", 80, squirtle, "Ciudad Celeste", 18);
        Entrenador brock = new Entrenador("Brock", 90, charmander, "Ciudad Plateada", 19);

        //Voz del presentador
        System.out.println("¡Bienvenidos al torneo de Kanto 2025!\n");
        System.out.println("Presentamos a los aspirantes a Líder del Gimnasio de Kanto:\n");

        System.out.println("En primer lugar:");
        ash.mostrarInfo();

        System.out.println("\nEn segundo lugar:");
        misty.mostrarInfo();

        System.out.println("\nY por último, y no por ello menos importante:");
        brock.mostrarInfo();

        System.out.println("\n¡Comienza el torneo, que gane el mejor!\n");
        
        //Orden de los combates
        List<Combate> combates = Arrays.asList(
            new Combate(ash, misty),
            new Combate(misty, brock),
            new Combate(ash, brock)
        );

        List<Entrenador> ganadores = new ArrayList<>();

        int numeroCombate = 1;
        for (Combate combate : combates) {
            ganadores.add(combate.realizarCombate(numeroCombate++));
        }

        Map<Entrenador, Integer> contadorVictorias = new HashMap<>();
        for (Entrenador ganador : ganadores) {
            contadorVictorias.put(ganador, contadorVictorias.getOrDefault(ganador, 0) + 1);
        }

        List<Entrenador> finalistas = new ArrayList<>();
        int maxVictorias = Collections.max(contadorVictorias.values());

        //Lógica contador de victorias
        for (Map.Entry<Entrenador, Integer> entry : contadorVictorias.entrySet()) {
            if (entry.getValue() == maxVictorias) {
                finalistas.add(entry.getKey());
            }
        }

        while (finalistas.size() > 1) {
            System.out.println("¡Combate de desempate!");
            Combate desempate = new Combate(finalistas.get(0), finalistas.get(1));
            Entrenador ganador = desempate.realizarCombate(numeroCombate++);
            finalistas.clear();
            finalistas.add(ganador);
        }

        System.out.println("¡" + finalistas.get(0).getNombre() + " es el nuevo Líder del Gimnasio de Kanto, enhorabuena!");
    }
}

//Clase Entrenador
class Entrenador {
    private String nombre;
    private int experiencia;
    private Pokemon pokemon;
    private String ciudadOrigen;
    private int edad;

    // Constructor
    public Entrenador(String nombre, int experiencia, Pokemon pokemon, String ciudadOrigen, int edad) {
        this.nombre = nombre;
        this.experiencia = experiencia;
        this.pokemon = pokemon;
        this.ciudadOrigen = ciudadOrigen;
        this.edad = edad;
    }

    public String getNombre() { return nombre; }
    public int getExperiencia() { return experiencia; }
    public Pokemon getPokemon() { return pokemon; }
    public String getCiudadOrigen() { return ciudadOrigen; }
    public int getEdad() { return edad; }
    
    // Método para mostrar la información del entrenador y su Pokémon
    public void mostrarInfo() {
        System.out.println("Entrenador: " + nombre + ", Experiencia: " + experiencia);
        System.out.print("Compañero: ");
        pokemon.mostrarInfo();
    }
}

//Clase Combate
class Combate {
    private Entrenador entrenador1;
    private Entrenador entrenador2;
    
    // Constructor de la clase Combate
    public Combate(Entrenador entrenador1, Entrenador entrenador2) {
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
    }

    public Entrenador realizarCombate(int numeroCombate) {
        System.out.println("¡Combate " + numeroCombate + "!");
        System.out.println(entrenador1.getNombre() + " vs " + entrenador2.getNombre());

        Pokemon p1 = entrenador1.getPokemon();
        Pokemon p2 = entrenador2.getPokemon();

        p1.setSalud(100);
        p2.setSalud(100);

        // Método que realiza el combate
        Random rand = new Random();
        boolean turno = rand.nextBoolean();
        
        
        //Lógica de combates
        while (p1.getSalud() > 0 && p2.getSalud() > 0) {
            if (turno) {
                System.out.println("¡" + p1.getNombre() + " ataca!");
                int dano = (p1 instanceof Pokemon.PokemonFuego) ? ((Pokemon.PokemonFuego)p1).lanzarEnviteIgneo() :
                           (p1 instanceof Pokemon.PokemonRayo) ? ((Pokemon.PokemonRayo)p1).lanzarChispa() :
                           ((Pokemon.PokemonAgua)p1).lanzarAcuaJet();
                p2.setSalud(p2.getSalud() - dano);
                System.out.println(p2.getNombre() + " sufre " + dano + " de daño. Salud restante: " + Math.max(p2.getSalud(), 0));
            } else {
                System.out.println("¡" + p2.getNombre() + " ataca!");
                int dano = (p2 instanceof Pokemon.PokemonFuego) ? ((Pokemon.PokemonFuego)p2).lanzarEnviteIgneo() :
                           (p2 instanceof Pokemon.PokemonRayo) ? ((Pokemon.PokemonRayo)p2).lanzarChispa() :
                           ((Pokemon.PokemonAgua)p2).lanzarAcuaJet();
                p1.setSalud(p1.getSalud() - dano);
                System.out.println(p1.getNombre() + " sufre " + dano + " de daño. Salud restante: " + Math.max(p1.getSalud(), 0));
            }
            turno = !turno;
        }

        Entrenador ganador = (p1.getSalud() > 0) ? entrenador1 : entrenador2;
        System.out.println("¡" + ganador.getNombre() + " gana el combate!\n");
        return ganador;
    }
}
