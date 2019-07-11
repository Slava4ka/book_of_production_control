package daos

import daos.tables.ProductTable
import models.Product

trait ProductDAO extends BaseDAO[ProductTable, Product]
