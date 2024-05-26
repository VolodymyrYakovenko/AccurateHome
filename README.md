# Accurate Home 

## Overview
This project aims to predict the estimated sale price of a house based on input features such as the number of rooms, bath, area and other characteristics. The project includes a trained machine learning model, a public API, and a mobile application for user interaction.

## Features
- **Machine Learning Model:** Trained on a comprehensive dataset of house features.
- **API:** Publicly accessible API for making predictions.
- **Mobile Application:** Under development, allows users to input house features and get price predictions.

## Getting Started

### Prerequisites
- Python 3.12
- installed dependencies in AccurateHome/AIModel/requirements.txt
- installed dependencies in AccurateHome/REST API/requirements.txt

### Installation

1. Clone the repository:
    ```bash
    https://github.com/VolodymyrYakovenko/AccurateHome.git
    ```
2. Navigate to the project directory:
    ```bash
    cd AccurateHome
    ```
3. Install the required packages(or in AccurateHome/AIModel, or in AccurateHome/REST API:
    ```bash
    pip install -r requirements.txt
    ```

### Running the API
1. Run the Flask app:
    ```bash
    python app.py
    ```
2. The API will be available at `http://localhost:5000`.

Note: Public API is available on `https://defline.pythonanywhere.com/`

### Using the API
Send a POST request to the `/getPredictionOutput` endpoint with a JSON payload containing the house features. Example:

```bash
curl -X POST http://localhost:5000//getPredictionOutput -H "Content-Type: application/json" -d '{
    "LotArea":[8450], 
    "YearBuilt":[2003], 
    "1stFlrSF":[856], 
    "2ndFlrSF":[854], 
    "FullBath":[2], 
    "BedroomAbvGr":[3], 
    "TotRmsAbvGrd":[8]
}'
