# COUPIN-INTERFACE on next.js

## Environment

- [Node.js](https://nodejs.org/en/)
- [NVM(Node Version Manager)](https://github.com/nvm-sh/nvm#installing-and-updating)
- [Yarn](https://classic.yarnpkg.com/en/docs/install)
- [IDE: Visual Studio Code](https://code.visualstudio.com/Download)

## Dependencies

- [Next.js & React.js](https://nextjs.org/docs/api-reference/create-next-app)

## Extension

- [Prettier](https://marketplace.visualstudio.com/items?itemName=esbenp.prettier-vscode)
  - setting(cmd + ',')
  - `default formatter` : esbenp.prettier-vscode
  - `format on save` : on

## History

1. Init project

   ```bash
   mkdir coupin-interface && cd coupin-interface
   npx create-next-app next && cd next
   ```

2. [Add gitinigore](https://www.toptal.com/developers/gitignore/api/windows,macos,linux,vscode,react,node,angular,sass,webstorm,visualstudiocode)

3. Run default next dev-server

   ```bash
   yarn dev
   ```

4. [Typescript](https://medium.com/@selvaganesh93/setup-next-js-with-typescript-integration-dece94e43cf5)

   ```bash
   yarn add @zeit/next-typescript @types/next @types/react
   ```

   ```javascript
   // in next.config.js
   const withTypescript = require("@zeit/next-typescript");
   module.exports = withTypescript({
     webpack(config, options) {
       return config;
     },
   });
   ```

   ```json
   // in .babelrc
   {
     "presets": ["next/babel", "@zeit/next-typescript/babel"]
   }
   ```

5. [scss](https://nextjs.org/docs/basic-features/built-in-css-support)

   ```bash
   yarn add sass
   ```

   - [Ref.](https://webisfree.com/2020-06-05/next-js-%EC%84%9C%EB%B2%84%EC%82%AC%EC%9D%B4%EB%93%9C-%EB%A0%8C%EB%8D%94%EB%A7%81%EC%9D%84-%EC%9C%84%ED%95%9C-react-framework)
