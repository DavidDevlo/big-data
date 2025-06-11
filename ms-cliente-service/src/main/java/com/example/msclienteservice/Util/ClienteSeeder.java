package com.example.msclienteservice.Util;

import com.example.msclienteservice.entity.Cliente;
import com.example.msclienteservice.repository.ClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteSeeder implements CommandLineRunner {

    private final ClienteRepository clienteRepository;

    public ClienteSeeder(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void run(String... args) {
        if (clienteRepository.count() == 0) {
            List<Cliente> clientes = new ArrayList<>();
            clientes.add(new Cliente("Av. Perú 123", "999111111", "cliente1@example.com", "Juan Pérez", "12345678", null));
            clientes.add(new Cliente("Jr. Lima 456", "999222222", "cliente2@example.com", "María Gómez", "23456789", null));
            clientes.add(new Cliente("Av. Cusco 789", "999333333", "cliente3@example.com", "Carlos Díaz", "34567890", null));
            clientes.add(new Cliente("Jr. Arequipa 101", "999444444", "cliente4@example.com", "Lucía Torres", "45678901", null));
            clientes.add(new Cliente("Av. Tacna 202", "999555555", "cliente5@example.com", "Pedro Rojas", "56789012", null));
            clientes.add(new Cliente("Jr. Puno 303", "999666666", "cliente6@example.com", "Ana Mendoza", "67890123", null));
            clientes.add(new Cliente("Av. Juliaca 404", "999777777", "cliente7@example.com", "Luis Chávez", "78901234", null));
            clientes.add(new Cliente("Jr. Moquegua 505", "999888888", "cliente8@example.com", "Rosa Salazar", "89012345", null));
            clientes.add(new Cliente("Av. Arequipa 606", "999999999", "cliente9@example.com", "José Ramírez", "90123456", null));
            clientes.add(new Cliente("Jr. Ica 707", "988111111", "cliente10@example.com", "Carmen Núñez", "01234567", null));
            clientes.add(new Cliente("Av. Loreto 808", "988222222", "cliente11@example.com", "Diego Herrera", "11112221", null));
            clientes.add(new Cliente("Jr. Ayacucho 909", "988333333", "cliente12@example.com", "Sofía Campos", "22223333", null));
            clientes.add(new Cliente("Av. Cajamarca 010", "988444444", "cliente13@example.com", "Mario Silva", "33334444", null));
            clientes.add(new Cliente("Jr. Trujillo 111", "988555555", "cliente14@example.com", "Teresa Flores", "44445555", null));
            clientes.add(new Cliente("Av. Huancayo 212", "988666666", "cliente15@example.com", "Renato Vega", "55556666", null));
            clientes.add(new Cliente("Jr. Chiclayo 313", "988777777", "cliente16@example.com", "Isabel Castro", "66667777", null));
            clientes.add(new Cliente("Av. Piura 414", "988888888", "cliente17@example.com", "Alfredo León", "77778888", null));
            clientes.add(new Cliente("Jr. Tumbes 515", "988999999", "cliente18@example.com", "Mónica Ríos", "88889999", null));
            clientes.add(new Cliente("Av. Amazonas 616", "987111111", "cliente19@example.com", "Óscar Meza", "99990000", null));
            clientes.add(new Cliente("Jr. Apurímac 717", "987222222", "cliente20@example.com", "Valeria Paredes", "00001111", null));
            clientes.add(new Cliente("Av. Madre de Dios 818", "987333333", "cliente21@example.com", "Eduardo Quiroz", "11112222", null));
            clientes.add(new Cliente("Jr. Ucayali 919", "987444444", "cliente22@example.com", "Pamela Zúñiga", "22223331", null));
            clientes.add(new Cliente("Av. San Martín 020", "987555555", "cliente23@example.com", "Santiago Navarro", "33331444", null));
            clientes.add(new Cliente("Jr. Grau 121", "987666666", "cliente24@example.com", "Verónica Palacios", "44445551", null));
            clientes.add(new Cliente("Av. Bolívar 222", "987777777", "cliente25@example.com", "Miguel Quispe", "55556662", null));

            clienteRepository.saveAll(clientes);
            System.out.println("✅ Clientes insertados correctamente.");
        } else {
            System.out.println("ℹ️ Los clientes ya existen, no se insertaron.");
        }
    }
}
