<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Healthcare Management System - Validation</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center mb-4">Healthcare Management System - Validation</h2>
        <form id="validationForm">
            <div class="mb-3">
                <label for="validationCode" class="form-label">Validation Code</label>
                <input type="text" class="form-control" id="validationCode" placeholder="Enter your validation code" required>
            </div>
            <button type="submit" class="btn btn-primary w-100">Validate</button>
        </form>
    </div>

    <!-- Bootstrap JS and Popper.js -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        document.getElementById('validationForm').addEventListener('submit', function(event) {
            event.preventDefault();

            const validationCode = document.getElementById('validationCode').value;

            if (validationCode.trim() === '') {
                alert('Validation code cannot be empty!');
                return;
            }

            console.log('Validation Code:', validationCode);
            alert('Validation successful!');
        });
    </script>
</body>
</html>
