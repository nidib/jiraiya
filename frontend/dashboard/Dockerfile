FROM node:alpine

WORKDIR /usr/app

COPY package.json ./

COPY package-lock.json ./

COPY ./ ./

RUN npm rebuild esbuild && npm install && npm run build

CMD ["npm", "run", "preview"]