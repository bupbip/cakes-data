package ru.kustikov.cakes.address;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressRecord getAddressById(Long id) {
        return addressRepository.findById(id)
                .map(addressMapper::entityToDto)
                .orElseThrow(() -> new RuntimeException("Address not found"));
    }

    public AddressRecord saveAddress(AddressRecord addressRecord) {
        AddressEntity addressEntity = addressMapper.dtoToEntity(addressRecord);
        AddressEntity savedAddress = addressRepository.save(addressEntity);
        return addressMapper.entityToDto(savedAddress);
    }
}
