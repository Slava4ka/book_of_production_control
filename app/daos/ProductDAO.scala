package daos

import daos.tables.ProductTable

trait ProductDAO extends BaseDAO[ProductTable, Product]
