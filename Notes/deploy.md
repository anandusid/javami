

using Docker:

created dockerfile.yml
	- specify java-version
	- jar location
	-jar name 
	- servicename
	
AWS - ECR, ECS are using for deployment

git-hub workaction is the CI/CD

deploy.yml

secrets are stored in the GITHub settings

name: Build and Deploy to AWS

on:
  push:
    branches:
      - main

jobs:
  build_and_deploy:
    runs-on: ubuntu-latest

    steps:
    # Step 1: Check out code from the GitHub repository
    - name: Checkout code
      uses: actions/checkout@v3

    # Step 2: Set up Docker Buildx
    - name: Set up Docker Buildx
      uses: docker/setup-buildx-action@v2

    # Step 3: Log in to Amazon ECR
    - name: Log in to Amazon ECR
      env:
        AWS_ACCESS_KEY_ID: ${{ secrets.AWS_ACCESS_KEY_ID }}
        AWS_SECRET_ACCESS_KEY: ${{ secrets.AWS_SECRET_ACCESS_KEY }}
        AWS_REGION: ${{ secrets.AWS_REGION }}
      run: |
        aws ecr get-login-password --region $AWS_REGION | docker login --username AWS --password-stdin ${{ secrets.ECR_REPOSITORY }}

    # Step 4: Build Docker image
    - name: Build Docker image
      run: docker build -t myapp:latest .

    # Step 5: Tag Docker image
    - name: Tag Docker image
      run: docker tag myapp:latest ${{ secrets.ECR_REPOSITORY }}:latest

    # Step 6: Push Docker image to ECR
    - name: Push to Amazon ECR
      run: docker push ${{ secrets.ECR_REPOSITORY }}:latest

    # Step 7: Deploy to Amazon ECS
    - name: Deploy to ECS
      env:
        AWS_ACCESS_KEY_ID: ${{ secrets.AWS_ACCESS_KEY_ID }}
        AWS_SECRET_ACCESS_KEY: ${{ secrets.AWS_SECRET_ACCESS_KEY }}
        AWS_REGION: ${{ secrets.AWS_REGION }}
      run: |
        aws ecs update-service --cluster my-cluster --service my-service --force-new-deployment


AWS RDS for Database

SCALING configuration are doing in ECS console. and using APPLICATION Load Balancer(ALB)
	