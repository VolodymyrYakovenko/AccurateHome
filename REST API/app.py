from flask import Flask, request, redirect
from flask_restful import Resource, Api
from flask_cors import CORS
import os
import prediction


app = Flask(__name__)
CORS(app)
api = Api(app)

class HomeAPI(Resource):
    def get(self):
        return 'Welcome to, HomeAPI!'
    
    def post(self):
        try:
            value = request.get_json()
            if(value):
                return {'Post Values': value}, 201
            return {"error":"Invalid format."}
        except Exception as error:
            return {'error': error}

class GetPredictionOutput(Resource):
    def get(self):
        return {"error":"Invlid method"}
    
    def post(self):
        try:
            data = request.get_json()
            if data is None:
                raise ValueError("No JSON data provided")

            predict = prediction.predict(data)
            return {'predict': predict}, 200
        
        except ValueError as e:
            app.logger.error("ValueError: %s", e)
            return {'error': str(e)}, 400 
        
        except Exception as e:
            app.logger.error("Exception: %s", e)
            return {'error': 'An unexpected error occurred', 'message': str(e)}, 500 
        
api.add_resource(HomeAPI, '/')
api.add_resource(GetPredictionOutput, '/getPredictionOutput')

if __name__ == "__main__":
    port = int(os.environ.get("PORT", 5000))
    app.run(host='0.0.0.0', port = port)
    