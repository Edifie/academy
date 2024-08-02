package com.ctw.workstation.rackasset.control;

import java.util.List;
import java.util.Optional;

import com.ctw.workstation.rackasset.entity.RackAsset;
import com.ctw.workstation.rackasset.repository.RackAssetRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class RackAssetService {

    @Inject
    RackAssetRepository rackAssetRepository;

    public List<RackAsset> findAll() {
        return rackAssetRepository.listAll();
    }

    public void add(RackAsset rackAsset) {
        rackAssetRepository.persist(rackAsset);
    }

    public Optional<RackAsset> findById(Long id) {
        return Optional.of(rackAssetRepository.findById(id));
    }

    public RackAsset update(RackAsset rackAsset) {
        RackAsset existedRackAssetOpt = Optional.of(rackAssetRepository.findById(rackAsset.getId())).orElse(null);

        if (existedRackAssetOpt != null) {

            existedRackAssetOpt.setRackId(rackAsset.getRackId());
            existedRackAssetOpt.setAssetTag(rackAsset.getAssetTag());

            rackAssetRepository.persist(existedRackAssetOpt);

            return existedRackAssetOpt;
        }
        return null;
    }

    public void delete(RackAsset rackAsset) {
        rackAssetRepository.delete(rackAsset);
    }

}
