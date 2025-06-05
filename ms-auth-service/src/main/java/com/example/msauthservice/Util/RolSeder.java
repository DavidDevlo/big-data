package com.example.msauthservice.Util;

import com.example.msauthservice.entity.Rol;
import com.example.msauthservice.repository.RolRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RolSeder implements CommandLineRunner {

    private final RolRepository rolRepository;

    public RolSeder(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public void run(String... args) {
        if (rolRepository.count() == 0) {
            List<Rol> rols = List.of(
                    new Rol(null,  "Tiene acceso completo a todos los módulos (usuarios, ventas, exportación)", "ADMIN"),
                    new Rol(null,  "Registra ventas, edita detalles de venta, genera pagos y facturas.", "VENDEDOR"),
                    new Rol(null,  "Revisa reportes, puede editar/validar facturas o pagos.", "SUPERVISOR"),
                    new Rol(null,  "Solo gestiona exportaciones, no ventas (si tienes módulo de exportación).", "EXPORTADOR"),
                    new Rol(null,  "Solo consulta El historial de la empresa de compras y facturas (si aplica en frontend).", "GERENTE")
        );

            rolRepository.saveAll(rols);
            System.out.println("✅ roles insertadas correctamente.");
        } else {
            System.out.println("ℹ️ Las roles ya existen, no se insertaron datos.");
        }
    }
}