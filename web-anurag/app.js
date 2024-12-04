document.addEventListener("DOMContentLoaded", () => {
    const content = document.getElementById("content");
    const routes = {
        home: `
            <div class="text-center">
                <h1>Welcome to the Healthcare Management System</h1>
                <p class="lead">Manage users, generate reports, and streamline your healthcare system.</p>
            </div>
        `,
        users: `
            <h1 class="text-center mb-4">User Management</h1>
            <form id="userForm" class="needs-validation" novalidate>
                <div class="mb-3">
                    <label for="username" class="form-label">Username</label>
                    <input type="text" class="form-control" id="username" name="username" required>
                    <div class="invalid-feedback">Please enter a valid username.</div>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" class="form-control" id="email" name="email" required>
                    <div class="invalid-feedback">Please enter a valid email address.</div>
                </div>
                <div class="mb-3">
                    <label for="role" class="form-label">Role</label>
                    <select class="form-select" id="role" name="role" required>
                        <option value="">Select Role</option>
                        <option value="admin">Admin</option>
                        <option value="doctor">Doctor</option>
                        <option value="patient">Patient</option>
                    </select>
                    <div class="invalid-feedback">Please select a user role.</div>
                </div>
                <div class="d-grid">
                    <button type="submit" class="btn btn-primary">Add User</button>
                </div>
            </form>

            <h2 class="mt-5">User List</h2>
            <table class="table table-striped mt-3" id="userTable">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Username</th>
                        <th>Email</th>
                        <th>Role</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody></tbody>
            </table>
        `,
        reports: `
            <h1 class="text-center">Reports</h1>
            <p class="lead text-center">Generate and view reports for user activity, system analytics, and more.</p>
        `
    };

    // Load content dynamically
    function loadPage(page) {
        content.innerHTML = routes[page];
        if (page === "users") {
            initUserManagement();
        }
    }

    // Initialize user management features
    function initUserManagement() {
        const userForm = document.getElementById("userForm");
        const userTable = document.getElementById("userTable").querySelector("tbody");
        let userId = 1;

        userForm.addEventListener("submit", (event) => {
            event.preventDefault();
            event.stopPropagation();

            if (userForm.checkValidity()) {
                addUser();
                userForm.reset();
            }
            userForm.classList.add("was-validated");
        });

        function addUser() {
            const username = document.getElementById("username").value;
            const email = document.getElementById("email").value;
            const role = document.getElementById("role").value;

            const row = userTable.insertRow();
            row.innerHTML = `
                <td>${userId++}</td>
                <td>${username}</td>
                <td>${email}</td>
                <td>${role}</td>
                <td>
                    <button class="btn btn-danger btn-sm delete-btn">Delete</button>
                </td>
            `;

            row.querySelector(".delete-btn").addEventListener("click", () => row.remove());
        }
    }

    // Set up navigation
    document.getElementById("nav-home").addEventListener("click", () => loadPage("home"));
    document.getElementById("nav-users").addEventListener("click", () => loadPage("users"));
    document.getElementById("nav-reports").addEventListener("click", () => loadPage("reports"));

    // Load home page initially
    loadPage("home");
});
