const express = require('express');
const cors = require('cors');
require('dotenv').config();

const app = express();
const port = process.env.PORT || 5000;

app.use(cors());
app.use(express.json());

// Routes
// const milkTeaRoutes = require('./routes/milktea');
// app.use('/api/milktea', milkTeaRoutes);

app.get('/', (req, res) => {
  res.send('Backend Server is running');
});

// Assuming MongoDB setup via mongoose
// mongoose.connect(process.env.MONGO_URI, ...);

app.listen(port, () => {
  console.log(`Server is running on port: ${port}`);
});
