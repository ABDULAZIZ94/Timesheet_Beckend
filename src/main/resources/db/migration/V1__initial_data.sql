  CREATE TABLE `status` (
    `stat_id` INT AUTO_INCREMENT PRIMARY KEY,
    `status` VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `user` (
  `user_id` INT AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE  `timesheet` (
    `timesheet_id` INT AUTO_INCREMENT PRIMARY KEY,
    `projectname` VARCHAR(255),
    `task` VARCHAR(255),
    `datefrom` DATE,
    `dateto` DATE,
    `user_id` INT,
    `stat_id` INT,
    FOREIGN KEY (user_id) REFERENCES user (user_id),
    FOREIGN KEY (stat_id) REFERENCES status (stat_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `status` (`stat_id`, `status`) VALUES
(1, 'Open'),
(2, 'In Progress'),
(3, 'Closed');

INSERT INTO `user` (`user_id`, `name`) VALUES
(1, 'aziz'),
(2, 'ahmad'),
(3, 'karim'),
(4, 'zaid');

INSERT INTO `timesheet` (`timesheet_id`,`projectname`,`task`,`datefrom`,`dateto`,`user_id`,`stat_id`) VALUES
(3,'Project D','Task D','2024-03-27','2024-03-27',1,1),
(4,'Project E','Task E','2024-03-27','2024-03-27',3,2),
(5,'Project F','Task F','2024-03-27','2024-03-27',2,1),
(6,'Project G','Task G','2024-03-27','2024-03-27',1,3),
(7,'Project H','Task H','2024-03-27','2024-03-27',3,3);

