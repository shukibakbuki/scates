name: Environment Variable Logging

on:
  push:
    branches:
      - main

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - name: Checkout Repository
        uses: actions/checkout@v2

      - name: Set Environment Variables
        run: |
          echo "MY_PASSWORD=secret123" >> $GITHUB_ENV
          echo "API_KEY=abcd1234" >> $GITHUB_ENV

      - name: Print Environment Variables
        run: |
          echo "MY_PASSWORD=$MY_PASSWORD"
          echo "API_KEY=$API_KEY"
      
      - name: Set Environment Variables
        run: |
          echo "MY_PASSWORD1=${{ SECRETS.EMAIL_ADDRESS }}" >> $GITHUB_ENV

      - name: Print Environment Variables
        run: |
          echo "MY_PASSWORD1=$MY_PASSWORD1"
