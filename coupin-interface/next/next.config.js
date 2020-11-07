// https://nextjs.org/docs/basic-features/built-in-css-support

const path = require("path");

module.exports = {
  sassOptions: {
    includePaths: [path.join(__dirname, "styles")],
  },
};

//typescript
// module.exports = withTypescript({
//   webpack(config, options) {
//     return config;
//   },
// });
