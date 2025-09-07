package br.com.livraria.service;

import br.com.livraria.model.domain.Address;
import br.com.livraria.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    public final AddressRepository addressRepository;

    public void create(Address address) {
        addressRepository.save(address);
    }

    public Address findById(Integer id){
        return addressRepository.findById(id).get();
    }

    public void update(Integer id, Address address) {
        Address oldAddress = addressRepository.findById(id).get();
        oldAddress.setResidentType(address.getResidentType());
        oldAddress.setStreetType(address.getStreetType());
        oldAddress.setStreet(address.getStreet());
        oldAddress.setNumber(address.getNumber());
        oldAddress.setNeighbor(address.getNeighbor());
        oldAddress.setCep(address.getCep());
        oldAddress.setCity(address.getCity());
        oldAddress.setState(address.getState());
        oldAddress.setCountry(address.getCountry());
        oldAddress.setCharge(address.getCharge());
        addressRepository.save(oldAddress);
    }

    public void delete(int id) {
        addressRepository.deleteById(id);
    }

}
