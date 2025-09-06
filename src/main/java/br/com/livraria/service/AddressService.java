package br.com.livraria.service;

import br.com.livraria.model.domain.User;
import br.com.livraria.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    public final AddressRepository addressRepository;

    public void createAddress() {

    }

    public void updateAddress() {
    }

    public void delete(int id) {
        addressRepository.deleteById(id);
    }

}
