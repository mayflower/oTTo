package de.mayflower.backend.helper

import io.azam.ulidj.ULID
import org.hibernate.engine.spi.SharedSessionContractImplementor
import org.hibernate.id.IdentifierGenerator

class UlidGenerator : IdentifierGenerator {
    override fun generate(p0: SharedSessionContractImplementor?, p1: Any?): Any {
        return ULID.random();
    }
}