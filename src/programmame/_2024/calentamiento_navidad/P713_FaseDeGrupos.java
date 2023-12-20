package programmame._2024.calentamiento_navidad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
public class P713_FaseDeGrupos {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String line = in.readLine();
        while (line != null){
            String[] valores = line.split(" ");
            int equiposTotales = Integer.parseInt(valores[0]);
            int equiposClasificados = Integer.parseInt(valores[1]);

            Equipo[] equipos = new Equipo[equiposTotales];
            for (int i = 0; i < equiposTotales; i++) {
                equipos[i] = new Equipo(i);
            }

            int numeroPartidos = equiposTotales * (equiposTotales - 1) / 2;

            for (int i = 0; i < numeroPartidos; i++) {
                String[] infoPartido = in.readLine().split(" ");
                procesarPartido(equipos, infoPartido);
            }

            Arrays.sort(equipos);

            if (equiposClasificados < equiposTotales && equipos[equiposClasificados - 1].equals(equipos[equiposClasificados])){
                System.out.println("EMPATE");
            }else{
                HashSet<Equipo> hashSet = new HashSet<>();
                StringBuilder strb = new StringBuilder();
                for (int i = 0; i < equiposClasificados; i++) {
                    Equipo equipo = equipos[i];
                    hashSet.add(equipo);
                    strb.append(equipo.getId() + 1).append(" ");
                }
                if (hashSet.size() == equiposClasificados){
                    System.out.println(strb.toString().trim());
                }else{
                    System.out.println("EMPATE");
                }
            }

            line = in.readLine();
        }
    }

    public static void procesarPartido(Equipo[] equipos, String[] infoPartido){
        Equipo equipoLocal = equipos[Integer.parseInt(infoPartido[0]) - 1];
        Equipo equipoVisitante = equipos[Integer.parseInt(infoPartido[1]) - 1];
        int golesEquipoLocal = Integer.parseInt(infoPartido[2]);
        int golesEquipoVisitante = Integer.parseInt(infoPartido[3]);

        if (golesEquipoLocal > golesEquipoVisitante){
            equipoLocal.sumarPuntos(3);
        } else if (golesEquipoVisitante > golesEquipoLocal) {
            equipoVisitante.sumarPuntos(3);
        }else{
            equipoLocal.sumarPuntos(1);
            equipoVisitante.sumarPuntos(1);
        }
        equipoLocal.sumarGolesAFavor(golesEquipoLocal);
        equipoLocal.sumarGolesEnContra(golesEquipoVisitante);
        equipoVisitante.sumarGolesAFavor(golesEquipoVisitante);
        equipoVisitante.sumarGolesEnContra(golesEquipoLocal);
    }
    public static class Equipo implements Comparable<Equipo>{
        private int id;
        private int puntos;
        private int golesFavor;
        private int diferenciaGoles;

        public Equipo(int id){
            this.id = id;
            this.puntos = 0;
            this.golesFavor = 0;
            this.diferenciaGoles = 0;
        }

        public int getPuntos() {
            return puntos;
        }

        public int getGolesFavor() {
            return golesFavor;
        }

        public int getId() {
            return id;
        }

        public int getDiferenciaGoles() {
            return diferenciaGoles;
        }

        public void sumarGolesAFavor(int goles){
            this.golesFavor += goles;
            this.diferenciaGoles += goles;
        }
        public void sumarGolesEnContra(int goles){
            this.diferenciaGoles -= goles;
        }

        public void sumarPuntos(int puntos){
            this.puntos += puntos;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Equipo equipo = (Equipo) o;

            if (puntos != equipo.puntos) return false;
            if (golesFavor != equipo.golesFavor) return false;
            return diferenciaGoles == equipo.diferenciaGoles;
        }

        @Override
        public int hashCode() {
            int result = puntos;
            result = 31 * result + golesFavor;
            result = 31 * result + diferenciaGoles;
            return result;
        }

        @Override
        public int compareTo(Equipo rival) {
            if (getPuntos() != rival.getPuntos()){
                return rival.getPuntos() - getPuntos();
            }else {
                if (getDiferenciaGoles() != rival.getDiferenciaGoles()){
                    return rival.getDiferenciaGoles() - getDiferenciaGoles();
                }else {
                    return rival.golesFavor - getGolesFavor();
                }
            }
        }
    }
}
