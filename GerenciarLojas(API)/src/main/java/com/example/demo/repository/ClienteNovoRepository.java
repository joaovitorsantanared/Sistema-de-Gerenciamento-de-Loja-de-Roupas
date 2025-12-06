    package com.example.demo.repository;

    import com.example.demo.model.Cliente.ClienteNovo;
    import org.springframework.data.jpa.repository.JpaRepository;

    import java.util.Optional;

    public interface ClienteNovoRepository extends JpaRepository<ClienteNovo, Long> {

        boolean existsByCpf(String cpf);// procura se tem alguém com o mesmo cpf

        Optional<ClienteNovo>findByCpf(String cpf);


    }
