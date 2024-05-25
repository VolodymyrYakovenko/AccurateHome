import pickle
import pandas as pd
import json
import os 

def predict(config):
    current_dir = os.path.dirname(__file__)
    model_path = os.path.join(current_dir, '..', 'AIModel', 'accuracyHouse_model.pkl')
    model_path = os.path.normpath(model_path)
    with open(model_path, 'rb') as f_in:
        model = pickle.load(f_in)
    if type(config) == dict:
        df = pd.DataFrame(config)
    else:
        df = config
    y_pred = model.predict(df)
    y_pred_list = y_pred.tolist()
    return y_pred_list