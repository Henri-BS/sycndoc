package com.pasifcode.cma_docs.init;

import com.pasifcode.cma_docs.domain.entity.Client;
import com.pasifcode.cma_docs.domain.entity.User;
import com.pasifcode.cma_docs.domain.enums.UserRoles;
import com.pasifcode.cma_docs.domain.repository.ClientRepository;
import com.pasifcode.cma_docs.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Component
public class StartApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    @Lazy
    private final PasswordEncoder passwordEncoder;
    private final ClientRepository clientRepository;

    @Autowired
    public StartApplication(UserRepository userRepository, PasswordEncoder passwordEncoder, ClientRepository clientRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.clientRepository = clientRepository;
    }

    @Transactional
    @Override
    public void run(String... args) {
        User user = userRepository.findByEmail("hbsantos720@gmail.com");
        if (user == null) {
            user = new User();
            user.setUsername("Henrique B. Santos");
            user.setEmail("hbsantos720@gmail.com");
            user.setPassword(passwordEncoder.encode("12345678"));
            user.setUserRoles(UserRoles.ADMIN);
            userRepository.save(user);
        }


        Client client1 = new Client();
        client1.setClientName("Maria Souza");
        client1.setClientNationality("brasileira");
        client1.setClientMaritalStatus("solteira");
        client1.setClientProfession("costureira");
        client1.setClientRgNumber("987654321");
        client1.setClientRgIssueDate(LocalDate.parse("2015-08-12"));
        client1.setClientCpf("123.456.789-00");
        client1.setClientBirthDate(LocalDate.parse("1990-07-25"));
        client1.setClientRelatives("José Souza (Pai)");
        client1.setClientAddress("Povoado Gameleira");
        client1.setClientResidentialNumber("789");
        client1.setClientDistrict("zona rural");
        client1.setClientCity("Caxias");
        client1.setClientUf("MA");
        client1.setClientCep("01310-100");
        client1.setWitness1Name("Carlos Mendes");
        client1.setWitness1Rg("753951456");
        client1.setWitness1Cpf("852.963.741-00");
        client1.setWitness2Name("Ana Beatriz");
        client1.setWitness2Rg("147258369");
        client1.setWitness2Cpf("951.753.852-00");
        client1.setUser(user);

        Client client2 = new Client();
        client2.setClientName("Ricardo Santos");
        client2.setClientNationality("brasileiro");
        client2.setClientMaritalStatus("casado");
        client2.setClientProfession("pedreiro");
        client2.setClientRgNumber("741852963");
        client2.setClientRgIssueDate(LocalDate.parse("2012-04-18"));
        client2.setClientCpf("369.258.147-00");
        client2.setClientBirthDate(LocalDate.parse("1982-09-30"));
        client2.setClientRelatives("Beatriz Santos (Filha)");
        client2.setClientAddress("Povoado Buriti");
        client2.setClientResidentialNumber("159");
        client2.setClientDistrict("zona rural");
        client2.setClientCity("Timon");
        client2.setClientUf("MA");
        client2.setClientCep("01400-200");
        client2.setWitness1Name("Roberto Lima");
        client2.setWitness1Rg("654321789");
        client2.setWitness1Cpf("789.456.123-00");
        client2.setWitness2Name("Sandra Rocha");
        client2.setWitness2Rg("357951258");
        client2.setWitness2Cpf("951.258.753-00");
        client2.setUser(user);

        Client client3 = new Client();
        client3.setClientName("João Silva");
        client3.setClientNationality("brasileiro");
        client3.setClientMaritalStatus("casado");
        client3.setClientProfession("lavrador");
        client3.setClientRgNumber("123456789");
        client3.setClientRgIssueDate(LocalDate.parse("2010-05-20"));
        client3.setClientCpf("987.654.321-00");
        client3.setClientBirthDate(LocalDate.parse("1985-03-15"));
        client3.setClientRelatives("Maria Silva (Esposa)");
        client3.setClientAddress("Povoado Brejinho");
        client3.setClientResidentialNumber("456");
        client3.setClientDistrict("zona rural");
        client3.setClientCity("Caxias");
        client3.setClientUf("MA");
        client3.setClientCep("01000-000");
        client3.setWitness1Name("Carlos Souza");
        client3.setWitness1Rg("456789123");
        client3.setWitness1Cpf("321.654.987-00");
        client3.setWitness2Name("Ana Pereira");
        client3.setWitness2Rg("789123456");
        client3.setWitness2Cpf("654.987.321-00");
        client3.setUser(user);

        Client client4 = new Client();
        client4.setClientName("Fernanda Oliveira");
        client4.setClientNationality("brasileira");
        client4.setClientMaritalStatus("viúva");
        client4.setClientProfession("lavradora");
        client4.setClientRgNumber("258963147");
        client4.setClientRgIssueDate(LocalDate.parse("2013-07-22"));
        client4.setClientCpf("147.258.369-00");
        client4.setClientBirthDate(LocalDate.parse("1987-05-10"));
        client4.setClientRelatives("Fernando Oliveira (Filho)");
        client4.setClientAddress("Povoado Laranjeiras");
        client4.setClientResidentialNumber("753");
        client4.setClientDistrict("zona rural");
        client4.setClientCity("São Luís");
        client4.setClientUf("MA");
        client4.setClientCep("01510-030");
        client4.setWitness1Name("Jorge Lima");
        client4.setWitness1Rg("753951258");
        client4.setWitness1Cpf("852.753.159-00");
        client4.setWitness2Name("Camila Santos");
        client4.setWitness2Rg("456789123");
        client4.setWitness2Cpf("321.654.987-00");
        client4.setUser(user);

        Client client5 = new Client();
        client5.setClientName("Pedro Nunes");
        client5.setClientNationality("brasileiro");
        client5.setClientMaritalStatus("solteiro");
        client5.setClientProfession("agricultor");
        client5.setClientRgNumber("753258951");
        client5.setClientRgIssueDate(LocalDate.parse("2017-09-15"));
        client5.setClientCpf("951.258.753-00");
        client5.setClientBirthDate(LocalDate.parse("1988-11-23"));
        client5.setClientRelatives("Carla Nunes (Mãe)");
        client5.setClientAddress("Povoado Santa Maria");
        client5.setClientResidentialNumber("753");
        client5.setClientDistrict("zona rural");
        client5.setClientCity("Caxias");
        client5.setClientUf("MA");
        client5.setClientCep("04101-000");
        client5.setWitness1Name("Eduardo Andrade");
        client5.setWitness1Rg("147258369");
        client5.setWitness1Cpf("258.147.369-00");
        client5.setWitness2Name("Vanessa Lopes");
        client5.setWitness2Rg("753951456");
        client5.setWitness2Cpf("951.753.852-00");
        client5.setUser(user);

        Client client6 = new Client();
        client6.setClientName("Luciana Ferreira");
        client6.setClientNationality("brasileira");
        client6.setClientMaritalStatus("casada");
        client6.setClientProfession("comerciante");
        client6.setClientRgNumber("258369147");
        client6.setClientRgIssueDate(LocalDate.parse("2014-05-10"));
        client6.setClientCpf("147.369.258-00");
        client6.setClientBirthDate(LocalDate.parse("1985-12-30"));
        client6.setClientRelatives("José Ferreira (Esposo)");
        client6.setClientAddress("Rua Grande, 450");
        client6.setClientResidentialNumber("159");
        client6.setClientDistrict("Centro");
        client6.setClientCity("São Luís");
        client6.setClientUf("MA");
        client6.setClientCep("01001-000");
        client6.setWitness1Name("Marcos Silva");
        client6.setWitness1Rg("987654321");
        client6.setWitness1Cpf("369.258.147-00");
        client6.setWitness2Name("Fernanda Costa");
        client6.setWitness2Rg("753951852");
        client6.setWitness2Cpf("321.789.654-00");
        client6.setUser(user);

        Client client7 = new Client();
        client7.setClientName("Roberto Lima");
        client7.setClientNationality("brasileiro");
        client7.setClientMaritalStatus("divorciado");
        client7.setClientProfession("lavrador");
        client7.setClientRgNumber("987321654");
        client7.setClientRgIssueDate(LocalDate.parse("2018-02-22"));
        client7.setClientCpf("654.321.987-00");
        client7.setClientBirthDate(LocalDate.parse("1979-06-15"));
        client7.setClientRelatives("Ana Lima (Filha)");
        client7.setClientAddress("Povoado Boa Vista");
        client7.setClientResidentialNumber("321");
        client7.setClientDistrict("zona rural");
        client7.setClientCity("Santa Inês");
        client7.setClientUf("MA");
        client7.setClientCep("04101-050");
        client7.setWitness1Name("Juliana Pereira");
        client7.setWitness1Rg("357951258");
        client7.setWitness1Cpf("951.258.753-00");
        client7.setWitness2Name("Carlos Mendes");
        client7.setWitness2Rg("753951456");
        client7.setWitness2Cpf("852.963.741-00");
        client7.setUser(user);

Client client8 = new Client();
        client8.setClientName("Eduardo Silva");
        client8.setClientNationality("brasileiro");
        client8.setClientMaritalStatus("casado");
        client8.setClientProfession("fazendeiro");
        client8.setClientRgNumber("789654321");
        client8.setClientRgIssueDate(LocalDate.parse("2011-06-10"));
        client8.setClientCpf("654.789.321-00");
        client8.setClientBirthDate(LocalDate.parse("1980-12-05"));
        client8.setClientRelatives("Amanda Silva (Esposa)");
        client8.setClientAddress("Povoado Barro Branco");
        client8.setClientResidentialNumber("852");
        client8.setClientDistrict("zona rural");
        client8.setClientCity("Caxias");
        client8.setClientUf("MA");
        client8.setClientCep("01002-000");
        client8.setProxyName("Roberto Souza");
        client8.setProxyCpf("321.654.987-00");
        client8.setProxyRg("951753852");
        client8.setProxyRelatives("Fernanda Souza (Filha)");
        client8.setProxyAddress("Rua das Orquídeas, 120");
        client8.setProxyDistrict("Centro");
        client8.setProxyCity("São Luís");
        client8.setProxyUf("MA");
        client8.setProxyCep("04102-100");
        client8.setWitness1Name("Marcos Lima");
        client8.setWitness1Rg("258963147");
        client8.setWitness1Cpf("147.258.369-00");
        client8.setWitness2Name("Juliana Costa");
        client8.setWitness2Rg("753951852");
        client8.setWitness2Cpf("321.789.654-00");
        client8.setUser(user);


        Client client9 = new Client();
        client9.setClientName("Beatriz Almeida");
        client9.setClientNationality("brasileira");
        client9.setClientMaritalStatus("solteira");
        client9.setClientProfession("engenheira");
        client9.setClientRgNumber("123789654");
        client9.setClientRgIssueDate(LocalDate.parse("2017-08-22"));
        client9.setClientCpf("987.321.654-00");
        client9.setClientBirthDate(LocalDate.parse("1995-02-18"));
        client9.setClientRelatives("Carlos Almeida (Pai)");
        client9.setClientAddress("Avenida Central, 410");
        client9.setClientResidentialNumber("951");
        client9.setClientDistrict("Jardins");
        client9.setClientCity("São Luís");
        client9.setClientUf("MA");
        client9.setClientCep("04103-000");
        client9.setProxyName("Jorge Ferreira");
        client9.setProxyCpf("369.147.258-00");
        client9.setProxyRg("951753852");
        client9.setProxyRelatives("Luciana Ferreira (Esposa)");
        client9.setProxyAddress("Rua das Palmeiras, 500");
        client9.setProxyDistrict("Centro");
        client9.setProxyCity("Timon");
        client9.setProxyUf("MA");
        client9.setProxyCep("01401-000");
        client9.setWitness1Name("Paulo Souza");
        client9.setWitness1Rg("753951258");
        client9.setWitness1Cpf("852.753.159-00");
        client9.setWitness2Name("Sandra Rocha");
        client9.setWitness2Rg("357951258");
        client9.setWitness2Cpf("951.258.753-00");
        client9.setUser(user);

        clientRepository.saveAll(List.of(client1, client2, client3, client4, client5, client6, client7, client8, client9));
    }
}