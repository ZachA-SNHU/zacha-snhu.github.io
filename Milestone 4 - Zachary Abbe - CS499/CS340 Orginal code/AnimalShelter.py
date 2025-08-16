from pymongo import MongoClient
from bson.objectid import ObjectId

class AnimalShelter(object):
    """ CRUD operations for Animal collection in MongoDB """

    def __init__(self, user, password):
        # Initializing the MongoClient. This helps to 
        # access the MongoDB databases and collections.
        # This is hard-wired to use the aac database, the 
        # animals collection, and the aac user.
        # Definitions of the connection string variables are
        # unique to the individual Apporto environment.
        #
        # You must edit the connection variables below to reflect
        # your own instance of MongoDB!
        #
        # Connection Variables
        #
        USER =  user    #'aacuser'
        PASS = password #'SNHU1234'
        HOST =  'nv-desktop-services.apporto.com'
        PORT =  33194
        DB =  'AAC'
        COL = 'animals'
        #
        # Initialize Connection
        #
        self.client = MongoClient('mongodb://%s:%s@%s:%d' % (USER,PASS,HOST,PORT))
        self.database = self.client['%s' % (DB)]
        self.collection = self.database['%s' % (COL)]

# Complete this create method to implement the C in CRUD.
    def create(self, data):
        if data is not None:
          try:
            insert = self.database.animals.insert_one(data)  # data should be dictionary
            return insert
          except Exception as e:
            print("insert failed: {e}")
          else:
            raise Exception("Nothing to save, because data parameter is empty")

# Create method to implement the R in CRUD.
    def read(self, searchTerm):
      if searchTerm is not None:
        try:
            result = self.database.animals.find(searchTerm) #sets results equal to list of animals matching search term
            return result
        except Exception as e:
          print("Read failed because searchTerm doesn't exist: {e}")
          
# Creating the method to implement the U in CRUD
    def update(self, searchData, updateData):
      if searchData is not None:
        try:
          result = self.database.animals.update_many(searchData, {"$set": updateData})
        except Exception as e:
          print("Update failed: {e}")
      else:
        return"{}"
		  #return the dataset if it is found
      return result.raw_result
		
		
# Creating the method to implement the D in CRUD
    def delete(self,deleteData):
      if deleteData is not None:
        result = self.database.animals.delete_many(deleteData)
        return result.deleted_count
      else:
        return"{}"
		#return the result 
      
    def readOne(self, searchTerm):
      if searchTerm is not None:
        return self.collection.find_one(searchTerm)
      else:
        raise Exception("SearchTerm is None")
